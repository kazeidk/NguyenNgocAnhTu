# 🎬 DEMO SCRIPT - SPORTS BOOKING SYSTEM

## KỊCH BẢN DEMO ĐẦY ĐỦ

### Chuẩn bị:
```bash
cd SportsBookingSystem
./run.sh
```

---

## DEMO 1: XEM CƠ SỞ VẬT CHẤT (2 phút)

### Bước 1: Xem tất cả cơ sở
```
Nhập: 1          # Facility Management
Nhập: 1          # View All Facilities
Press Enter
```

**Kết quả:** Hiển thị 7 cơ sở mặc định

### Bước 2: Xem cơ sở khả dụng
```
Nhập: 2          # View Available Facilities
Press Enter
```

**Kết quả:** Tất cả đều Available

### Bước 3: Tìm kiếm theo loại
```
Nhập: 5          # Search by Type
Nhập: Tennis
Press Enter
```

**Kết quả:** Hiển thị 2 sân tennis

```
Nhập: 0          # Back to main menu
```

---

## DEMO 2: TẠO ĐẶT CHỖ (3 phút)

### Bước 1: Tạo booking hợp lệ
```
Nhập: 2          # Booking Management
Nhập: 1          # Create New Booking
```

**Nhập thông tin:**
```
Facility ID: TC001
Customer Name: Nguyen Van A
Phone Number: 0912345678
Booking Date: 20/11/2025     # Chọn ngày tương lai
Start Hour: 14
End Hour: 16
Confirm? Y
```

**Kết quả:** 
- ✓ Booking created successfully!
- Booking ID: BK1001
- Total Price: $50.00

```
Press Enter
```

### Bước 2: Tạo booking thứ 2
```
Nhập: 1          # Create New Booking
Facility ID: FB001
Customer Name: Tran Thi B
Phone Number: 0987654321
Booking Date: 20/11/2025
Start Hour: 10
End Hour: 12
Confirm? Y
```

**Kết quả:** BK1002 created, Price: $100.00

```
Press Enter
Nhập: 0          # Back to main menu
```

---

## DEMO 3: TEST VALIDATION (3 phút)

### Test 1: Tên không hợp lệ
```
Nhập: 2          # Booking Management
Nhập: 1          # Create New Booking
Facility ID: TC002
Customer Name: A            # Quá ngắn
```

**Kết quả:** ❌ Invalid name! Yêu cầu nhập lại

```
Customer Name: 123          # Có số
```

**Kết quả:** ❌ Invalid name! Yêu cầu nhập lại

```
Customer Name: Le Van C     # Hợp lệ
```

**Kết quả:** ✓ Chấp nhận

### Test 2: Số điện thoại không hợp lệ
```
Phone Number: 123           # Quá ngắn
```

**Kết quả:** ❌ Invalid phone number!

```
Phone Number: 0909123456    # Hợp lệ
```

**Kết quả:** ✓ Chấp nhận

### Test 3: Ngày quá khứ
```
Booking Date: 01/01/2020    # Quá khứ
```

**Kết quả:** ❌ Cannot book for past dates!

```
Booking Date: 20/11/2025    # Tương lai
```

**Kết quả:** ✓ Chấp nhận

### Hoàn thành booking
```
Start Hour: 16
End Hour: 18
Confirm? Y
```

```
Press Enter
Nhập: 0
```

---

## DEMO 4: KIỂM TRA TRÙNG LỊCH (2 phút)

### Tạo booking trùng giờ
```
Nhập: 2          # Booking Management
Nhập: 1          # Create New Booking
Facility ID: TC001
Customer Name: Pham Van D
Phone Number: 0901234567
Booking Date: 20/11/2025    # Cùng ngày với BK1001
Start Hour: 15              # Trùng với 14:00-16:00
End Hour: 17
Confirm? Y
```

**Kết quả:** ❌ This time slot is already booked!

### Tạo booking không trùng
```
# Thử lại
Nhập: 1
Facility ID: TC001
Customer Name: Pham Van D
Phone Number: 0901234567
Booking Date: 20/11/2025
Start Hour: 16              # Không trùng (14-16 đã hết)
End Hour: 18
Confirm? Y
```

**Kết quả:** ✓ BK1003 created successfully!

```
Press Enter
Nhập: 0
```

---

## DEMO 5: XEM & TÌM KIẾM BOOKING (3 phút)

### Xem tất cả bookings
```
Nhập: 2          # Booking Management
Nhập: 2          # View All Bookings
Press Enter
```

**Kết quả:** Hiển thị tất cả 3-4 bookings

### Xem bookings theo ngày
```
Nhập: 7          # View Bookings by Date
Nhập: 20/11/2025
Press Enter
```

**Kết quả:** Hiển thị bookings ngày 20/11, sắp xếp theo giờ

### Tìm theo tên khách hàng
```
Nhập: 5          # Search by Customer Name
Nhập: Nguyen
Press Enter
```

**Kết quả:** Hiển thị booking của "Nguyen Van A"

### Tìm theo số điện thoại
```
Nhập: 6          # Search by Phone
Nhập: 0912345678
Press Enter
```

**Kết quả:** Hiển thị booking với SĐT đó

```
Nhập: 0
```

---

## DEMO 6: HỦY BOOKING (2 phút)

### Hủy một booking
```
Nhập: 2          # Booking Management
Nhập: 4          # Cancel Booking
```

**Hiển thị:** Danh sách active bookings

```
Nhập: BK1002     # Nhập ID booking cần hủy
Confirm? Y
Press Enter
```

**Kết quả:** ✓ Booking cancelled successfully!

### Kiểm tra lại
```
Nhập: 3          # View Active Bookings
```

**Kết quả:** BK1002 không còn trong danh sách active

```
Nhập: 2          # View All Bookings
```

**Kết quả:** BK1002 vẫn có nhưng status = CANCELLED

```
Press Enter
Nhập: 0
```

---

## DEMO 7: THỐNG KÊ DOANH THU (2 phút)

### Xem thống kê
```
Nhập: 3          # View Statistics
Nhập: 1          # Revenue Statistics
```

**Kết quả hiển thị:**
```
=== REVENUE STATISTICS ===
Total Bookings: 4
Active Bookings: 3        # BK1002 đã cancelled
Cancelled Bookings: 1
Total Revenue: $XXX.XX    # Chỉ tính active
```

**Giải thích tính toán:**
- BK1001: TC001, 2h x $25 = $50 ✓
- BK1002: FB001, 2h x $50 = $100 ❌ (cancelled)
- BK1003: TC001, 2h x $25 = $50 ✓
- BK10XX: TC002, 2h x $25 = $50 ✓
- **Total: $150** (không tính BK1002)

```
Press Enter
Nhập: 0
```

---

## DEMO 8: QUẢN LÝ CƠ SỞ (2 phút)

### Thêm cơ sở mới
```
Nhập: 1          # Facility Management
Nhập: 3          # Add New Facility
```

**Nhập:**
```
Facility ID: SW001
Facility Name: Ho Boi Olimpia
Facility Type: Swimming
Price per Hour: 45
```

**Kết quả:** ✓ Facility added successfully!

```
Press Enter
```

### Cập nhật trạng thái
```
Nhập: 4          # Update Facility Status
Nhập: TC001      # Facility ID
Nhập: 2          # Set to Unavailable
Press Enter
```

**Kết quả:** ✓ Status updated

### Kiểm tra
```
Nhập: 2          # View Available Facilities
```

**Kết quả:** TC001 không còn trong danh sách available

```
Press Enter
Nhập: 0
Nhập: 0
```

---

## DEMO 9: THOÁT CHƯƠNG TRÌNH

```
Nhập: 0          # Exit
Nhập: Y          # Confirm
```

**Kết quả:**
```
Thank you for using Sports Booking System!
Goodbye!
```

---

## 📊 CHECKLIST DEMO

### Features Demonstrated:
- [x] Xem danh sách cơ sở
- [x] Tìm kiếm cơ sở theo loại
- [x] Thêm cơ sở mới
- [x] Cập nhật trạng thái cơ sở
- [x] Tạo booking hợp lệ
- [x] Validation tên khách hàng
- [x] Validation số điện thoại
- [x] Validation ngày quá khứ
- [x] Kiểm tra trùng lịch
- [x] Xem tất cả bookings
- [x] Xem bookings theo ngày
- [x] Tìm kiếm theo tên
- [x] Tìm kiếm theo SĐT
- [x] Hủy booking
- [x] Thống kê doanh thu
- [x] Tính toán giá chính xác
- [x] Menu navigation
- [x] Exit confirmation

---

## 💡 TIPS CHO DEMO

### Chuẩn bị:
1. Chạy thử 1 lần trước khi demo
2. Chuẩn bị sẵn ngày tương lai (VD: 20/11/2025)
3. Ghi nhớ các Booking ID đã tạo

### Trong demo:
1. Giải thích từng bước
2. Chỉ rõ validation messages
3. Demo cả trường hợp lỗi
4. Highlight các tính năng nổi bật

### Các điểm nhấn:
- ✅ Validation chặt chẽ
- ✅ Kiểm tra trùng lịch tự động
- ✅ Tính giá tự động
- ✅ Nhiều cách tìm kiếm
- ✅ Thống kê chính xác
- ✅ UX thân thiện

---

## ⏱️ THỜI GIAN DEMO

- Demo nhanh: 5 phút (DEMO 1, 2, 5, 6)
- Demo đầy đủ: 15 phút (tất cả demos)
- Demo chi tiết: 20 phút (với giải thích)

---

## 📝 NOTES

### Data mẫu có sẵn:
- 7 cơ sở: TC001, TC002, FB001, FB002, BB001, BM001, BM002
- Giá: Tennis $25, Football $50, Basketball $30, Badminton $20
- Giờ: 06:00 - 22:00

### Số điện thoại test:
- 0912345678
- 0987654321
- 0909123456
- 0901234567

### Tên test:
- Nguyen Van A
- Tran Thi B
- Le Van C
- Pham Van D

---

**Chúc bạn demo thành công! 🎉**
