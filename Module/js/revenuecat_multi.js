// ========================================
// RevenueCat Multi-App Premium Unlocker
// ⚡ Performance: Ultra-Fast & Universal
// 🔐 Supports: Locket Gold + VSCO Premium
// 📅 Version: 1.0 (2025-11-02)
// ========================================

(function() {
  'use strict';
  
  // ========= Constants ========= //
  const PURCHASE_DATE = "2025-07-18T00:00:00Z";
  const EXPIRES_DATE = "2099-07-18T23:59:59Z";
  
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
  
  // ========= Parse Response ========= //
  let responseObj;
  try {
    responseObj = JSON.parse($response.body);
    if (!responseObj.subscriber) {
      responseObj.subscriber = { subscriptions: {}, entitlements: {} };
    }
  } catch (error) {
    responseObj = { subscriber: { subscriptions: {}, entitlements: {} } };
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
  
  // ========= Detect App & Apply Config ========= //
  if (ua.includes('Locket')) {
    // Locket Gold
    const config = APP_CONFIGS['Locket'];
    responseObj.subscriber.subscriptions[config.productId] = createSubscription(config.productId);
    responseObj.subscriber.entitlements[config.entitlement] = createEntitlement(config.productId);
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
  }
  else {
    // Default: Locket
    const config = APP_CONFIGS['Locket'];
    responseObj.subscriber.subscriptions[config.productId] = createSubscription(config.productId);
    responseObj.subscriber.entitlements[config.entitlement] = createEntitlement(config.productId);
  }
  
  // ========= Return Response ========= //
  $done({ body: JSON.stringify(responseObj) });
  
})();
