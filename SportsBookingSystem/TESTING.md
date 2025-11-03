# Hướng dẫn kiểm thử (Testing Guide)

## Test Cases - Sports Booking System

### 1. Test Facility Management

#### TC-F1: Xem tất cả cơ sở (View All Facilities)
**Bước:**
1. Chọn menu "1. Facility Management"
2. Chọn "1. View All Facilities"

**Kết quả mong đợi:**
- Hiển thị danh sách 7 cơ sở mặc định
- Mỗi cơ sở có: ID, Name, Type, Price, Status

#### TC-F2: Thêm cơ sở mới (Add New Facility)
**Bước:**
1. Chọn menu "1. Facility Management"
2. Chọn "3. Add New Facility"
3. Nhập: ID="SW001", Name="Swimming Pool", Type="Swimming", Price=40

**Kết quả mong đợi:**
- Thông báo "Facility added successfully!"
- Cơ sở mới xuất hiện trong danh sách

#### TC-F3: Cập nhật trạng thái (Update Status)
**Bước:**
1. Chọn menu "1. Facility Management"
2. Chọn "4. Update Facility Status"
3. Nhập ID="TC001", chọn "2. Set to Unavailable"

**Kết quả mong đợi:**
- Thông báo "Facility status updated successfully!"
- TC001 hiển thị status "Unavailable"

#### TC-F4: Tìm kiếm theo loại (Search by Type)
**Bước:**
1. Chọn menu "1. Facility Management"
2. Chọn "5. Search Facilities by Type"
3. Nhập type="Tennis"

**Kết quả mong đợi:**
- Hiển thị 2 sân tennis (TC001, TC002)

---

### 2. Test Booking Management

#### TC-B1: Tạo đặt chỗ hợp lệ (Create Valid Booking)
**Bước:**
1. Chọn menu "2. Booking Management"
2. Chọn "1. Create New Booking"
3. Nhập:
   - Facility ID: TC001
   - Customer Name: Nguyen Van A
   - Phone: 0912345678
   - Date: 15/11/2025 (ngày tương lai)
   - Start Hour: 14
   - End Hour: 16
4. Confirm: Y

**Kết quả mong đợi:**
- Thông báo "Booking created successfully!"
- Hiển thị Booking ID (ví dụ: BK1001)
- Tính đúng giá: $25 x 2 giờ = $50

#### TC-B2: Test validation - Tên không hợp lệ
**Bước:**
1. Tạo booking mới
2. Nhập tên: "123" hoặc "A"

**Kết quả mong đợi:**
- Thông báo lỗi: "Invalid name!"
- Yêu cầu nhập lại

#### TC-B3: Test validation - Số điện thoại không hợp lệ
**Bước:**
1. Tạo booking mới
2. Nhập phone: "123" hoặc "abcd"

**Kết quả mong đợi:**
- Thông báo lỗi: "Invalid phone number!"
- Yêu cầu nhập lại 10-11 chữ số

#### TC-B4: Test validation - Ngày quá khứ
**Bước:**
1. Tạo booking mới
2. Nhập date: "01/01/2020"

**Kết quả mong đợi:**
- Thông báo: "Cannot book for past dates!"
- Yêu cầu nhập ngày hiện tại hoặc tương lai

#### TC-B5: Test trùng lặp thời gian
**Bước:**
1. Tạo booking: TC001, 15/11/2025, 14:00-16:00
2. Tạo booking khác: TC001, 15/11/2025, 15:00-17:00

**Kết quả mong đợi:**
- Booking thứ 2 bị từ chối
- Thông báo: "This time slot is already booked!"

#### TC-B6: Hủy đặt chỗ (Cancel Booking)
**Bước:**
1. Chọn "4. Cancel Booking"
2. Nhập Booking ID: BK1001
3. Confirm: Y

**Kết quả mong đợi:**
- Thông báo "Booking cancelled successfully!"
- Status thay đổi thành "CANCELLED"

#### TC-B7: Tìm kiếm theo tên khách hàng
**Bước:**
1. Chọn "5. Search Bookings by Customer Name"
2. Nhập: "Nguyen"

**Kết quả mong đợi:**
- Hiển thị tất cả booking có tên chứa "Nguyen"

#### TC-B8: Tìm kiếm theo số điện thoại
**Bước:**
1. Chọn "6. Search Bookings by Phone Number"
2. Nhập: "0912345678"

**Kết quả mong đợi:**
- Hiển thị tất cả booking với số điện thoại đó

#### TC-B9: Xem booking theo ngày
**Bước:**
1. Chọn "7. View Bookings by Date"
2. Nhập: 15/11/2025

**Kết quả mong đợi:**
- Hiển thị tất cả booking ACTIVE trong ngày
- Sắp xếp theo thời gian bắt đầu

---

### 3. Test Statistics & Reports

#### TC-S1: Xem thống kê doanh thu
**Bước:**
1. Chọn menu "3. View Statistics"
2. Chọn "1. View Revenue Statistics"

**Kết quả mong đợi:**
- Hiển thị:
  - Total Bookings
  - Active Bookings
  - Cancelled Bookings
  - Total Revenue (chỉ tính ACTIVE)

#### TC-S2: Kiểm tra tính toán doanh thu
**Test data:**
- Booking 1: TC001 (Tennis $25), 2 giờ = $50
- Booking 2: FB001 (Football $50), 3 giờ = $150
- Total = $200

**Kết quả mong đợi:**
- Total Revenue hiển thị chính xác

---

### 4. Test Edge Cases

#### TC-E1: Booking giờ biên (6:00 và 22:00)
**Bước:**
1. Tạo booking: 6:00-8:00 (hợp lệ)
2. Tạo booking: 21:00-22:00 (hợp lệ)
3. Tạo booking: 5:00-7:00 (không hợp lệ)
4. Tạo booking: 22:00-23:00 (không hợp lệ)

**Kết quả mong đợi:**
- 1,2 thành công
- 3,4 bị từ chối

#### TC-E2: Chuỗi UTF-8 (tiếng Việt)
**Bước:**
1. Tạo booking với tên: "Nguyễn Văn Á"

**Kết quả mong đợi:**
- Hệ thống chấp nhận tên tiếng Việt
- Hiển thị đúng ký tự đặc biệt

#### TC-E3: Input rất dài
**Bước:**
1. Nhập tên có 100 ký tự

**Kết quả mong đợi:**
- Hệ thống xử lý bình thường
- Không bị crash

---

### 5. Test User Experience

#### TC-U1: Menu navigation
**Bước:**
1. Thử tất cả menu options
2. Quay lại menu chính từ mỗi submenu

**Kết quả mong đợi:**
- Navigation mượt mà
- Không bị lỗi

#### TC-U2: Input validation messages
**Kiểm tra:**
- Mỗi lỗi có thông báo rõ ràng
- User biết phải làm gì tiếp theo

#### TC-U3: Exit confirmation
**Bước:**
1. Chọn "0. Exit" từ main menu
2. Nhập "N" → tiếp tục
3. Chọn "0. Exit" lại
4. Nhập "Y" → thoát

**Kết quả mong đợi:**
- Confirmation dialog xuất hiện
- Thoát khi confirm

---

## Test Execution Checklist

### Functionality Tests
- [ ] TC-F1: View All Facilities
- [ ] TC-F2: Add New Facility
- [ ] TC-F3: Update Status
- [ ] TC-F4: Search by Type

### Booking Tests
- [ ] TC-B1: Create Valid Booking
- [ ] TC-B2: Invalid Name Validation
- [ ] TC-B3: Invalid Phone Validation
- [ ] TC-B4: Past Date Validation
- [ ] TC-B5: Time Overlap Check
- [ ] TC-B6: Cancel Booking
- [ ] TC-B7: Search by Customer
- [ ] TC-B8: Search by Phone
- [ ] TC-B9: View by Date

### Statistics Tests
- [ ] TC-S1: View Revenue Statistics
- [ ] TC-S2: Revenue Calculation

### Edge Cases
- [ ] TC-E1: Boundary Hours
- [ ] TC-E2: UTF-8 Characters
- [ ] TC-E3: Long Input

### UX Tests
- [ ] TC-U1: Menu Navigation
- [ ] TC-U2: Error Messages
- [ ] TC-U3: Exit Confirmation

---

## Automated Test Script

Để test tự động, có thể tạo file input:
```
test_input.txt
--------------
1
1
0
2
1
TC001
Nguyen Van A
0912345678
15/11/2025
14
16
Y
0
0
Y
```

Chạy: `java Main < test_input.txt`

---

## Bug Report Template

```
Bug ID: BUG-XXX
Title: [Mô tả ngắn gọn]
Severity: [Critical/High/Medium/Low]
Steps to Reproduce:
1. ...
2. ...
Expected Result: ...
Actual Result: ...
Screenshots: [nếu có]
```

---

## Test Results Summary

| Category | Total Tests | Passed | Failed | Pass Rate |
|----------|------------|--------|--------|-----------|
| Facility | 4 | - | - | - |
| Booking | 9 | - | - | - |
| Statistics | 2 | - | - | - |
| Edge Cases | 3 | - | - | - |
| UX | 3 | - | - | - |
| **TOTAL** | **21** | - | - | - |

---

**Note**: Điền kết quả test vào bảng trên sau khi hoàn thành testing.
