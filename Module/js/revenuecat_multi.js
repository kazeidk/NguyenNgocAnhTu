// ========================================
// RevenueCat Multi-App Premium Unlocker
// ⚡ Performance: Ultra-Fast & Universal
// 🔐 Supports: Locket Gold + VSCO Premium
// 📅 Version: 1.1 (2025-11-15) - Enhanced
// 👤 Author: z3rokaze
// ========================================

(function() {
  'use strict';
  
  // ========= Constants (Updated) ========= //
  const PURCHASE_DATE = "2025-11-15T00:00:00Z";  // ✅ Current date
  const EXPIRES_DATE = "2099-12-31T23:59:59Z";   // ✅ Lifetime
  
  // ========= App Configurations ========= //
  const APP_CONFIGS = {
    'Locket': {
      entitlement: 'Gold',
      productId: 'locket.premium.yearly'
    },
    'VSCO': {
      entitlements: ['membership'],
      products: ['VSCOANNUAL', 'VSCOCAM02BUALL', 'VSCOCAM02BULE0001', 'VSCOCAM02BUXXCC01']
    }
  };
  
  // ========= Get User-Agent ========= //
  const headers = $request.headers;
  const ua = headers["User-Agent"] || headers["user-agent"] || "";
  
  // ========= Parse Response (Enhanced Error Handling) ========= //
  let responseObj;
  try {
    responseObj = JSON.parse($response.body);
    // Ensure structure exists
    if (!responseObj.subscriber) {
      responseObj.subscriber = {};
    }
    if (!responseObj.subscriber.subscriptions) {
      responseObj.subscriber.subscriptions = {};
    }
    if (!responseObj.subscriber.entitlements) {
      responseObj.subscriber.entitlements = {};
    }
  } catch (error) {
    // Fallback with complete structure
    responseObj = { 
      subscriber: { 
        subscriptions: {}, 
        entitlements: {},
        original_app_user_id: "",
        original_application_version: ""
      } 
    };
  }
  
  // ========= Base Subscription Data ========= //
  const createSubscription = (productId) => ({
    is_sandbox: false,
    ownership_type: "PURCHASED",
    billing_issues_detected_at: null,
    period_type: "normal",
    expires_date: EXPIRES_DATE,
    grace_period_expires_date: null,
    unsubscribe_detected_at: null,
    original_purchase_date: PURCHASE_DATE,
    purchase_date: PURCHASE_DATE,
    store: "app_store"
  });
  
  const createEntitlement = (productId) => ({
    grace_period_expires_date: null,
    purchase_date: PURCHASE_DATE,
    product_identifier: productId,
    expires_date: EXPIRES_DATE
  });
  
  // ========= Detect App & Apply Config (Enhanced) ========= //
  let appDetected = false;
  
  if (ua.includes('Locket')) {
    // Locket Gold
    const config = APP_CONFIGS['Locket'];
    responseObj.subscriber.subscriptions[config.productId] = createSubscription(config.productId);
    responseObj.subscriber.entitlements[config.entitlement] = createEntitlement(config.productId);
    appDetected = true;
  }
  else if (ua.includes('VSCO')) {
    // VSCO Premium
    const config = APP_CONFIGS['VSCO'];
    config.products.forEach(productId => {
      responseObj.subscriber.subscriptions[productId] = createSubscription(productId);
    });
    config.entitlements.forEach(entKey => {
      responseObj.subscriber.entitlements[entKey] = createEntitlement(config.products[0]);
    });
    appDetected = true;
  }
  
  // Default fallback: Locket (if no app detected)
  if (!appDetected) {
    const config = APP_CONFIGS['Locket'];
    responseObj.subscriber.subscriptions[config.productId] = createSubscription(config.productId);
    responseObj.subscriber.entitlements[config.entitlement] = createEntitlement(config.productId);
  }
  
  // ========= Return Response ========= //
  $done({ body: JSON.stringify(responseObj) });
  
})();
