// ========================================
// RevenueCat ETag Header Remover - Enhanced
// ⚡ Performance: Ultra Fast
// 🔐 Remove caching headers for RevenueCat apps
// 📅 Version: 1.2 (2025-12-01)
// 👤 Author: z3rokaze
// ========================================

(function () {
  'use strict';

  // Get request headers (Direct reference - fastest)
  const headers = $request.headers;

  // Remove ETag headers (All possible cases)
  delete headers["X-RevenueCat-ETag"];
  delete headers["x-revenuecat-etag"];
  delete headers["X-REVENUECAT-ETAG"];

  // Also remove If-None-Match (additional caching header)
  delete headers["If-None-Match"];
  delete headers["if-none-match"];

  // Return modified headers (Fastest return)
  $done({ headers: headers });

})();
