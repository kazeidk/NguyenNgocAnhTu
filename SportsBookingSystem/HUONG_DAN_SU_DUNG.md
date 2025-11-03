# HƯỚNG DẪN SỬ DỤNG HỆ THỐNG ĐẶT SÂN THỂ THAO

## MỤC LỤC
1. [Giới thiệu](#giới-thiệu)
2. [Cài đặt](#cài-đặt)
3. [Chạy chương trình](#chạy-chương-trình)
4. [Hướng dẫn chi tiết các chức năng](#hướng-dẫn-chi-tiết)
5. [Các lưu ý quan trọng](#lưu-ý-quan-trọng)

---

## GIỚI THIỆU

Hệ thống Đặt Sân Thể Thao là ứng dụng console giúp quản lý:
- ⚽ Sân bóng đá
- 🎾 Sân tennis  
- 🏀 Sân bóng rổ
- 🏸 Sân cầu lông

### Tính năng chính:
✅ Quản lý cơ sở vật chất (thêm, xem, cập nhật)  
✅ Đặt chỗ trực tuyến với kiểm tra trùng lặp  
✅ Hủy đặt chỗ dễ dàng  
✅ Tìm kiếm đa dạng (theo tên, SĐT, ngày)  
✅ Thống kê doanh thu tự động  

---

## CÀI ĐẶT

### Yêu cầu:
- Java JDK 8 trở lên
- Terminal hỗ trợ UTF-8

### Kiểm tra Java:
```bash
java -version
```
Nếu chưa có Java, tải tại: https://www.oracle.com/java/technologies/downloads/

---

## CHẠY CHƯƠNG TRÌNH

### Cách 1: Dùng script (Khuyến nghị)

**Linux/Mac:**
```bash
./run.sh
```

**Windows:**
```batch
run.bat
```

### Cách 2: Chạy thủ công

**Bước 1: Biên dịch**
```bash
cd SportsBookingSystem
mkdir -p bin
javac -d bin src/*.java src/model/*.java src/manager/*.java src/util/*.java src/view/*.java
```

**Bước 2: Chạy**
```bash
cd bin
java Main
```

---

## HƯỚNG DẪN CHI TIẾT

### 🏗️ PHẦN 1: QUẢN LÝ CƠ SỞ

#### 1.1 Xem tất cả cơ sở
```
Menu chính → 1 → 1
```
- Hiển thị danh sách đầy đủ tất cả cơ sở
- Thông tin: ID, Tên, Loại, Giá/giờ, Trạng thái

#### 1.2 Xem cơ sở khả dụng
```
Menu chính → 1 → 2
```
- Chỉ hiển thị cơ sở đang có thể đặt
- Dùng trước khi tạo booking

#### 1.3 Thêm cơ sở mới
```
Menu chính → 1 → 3
```
**Ví dụ:**
```
Enter Facility ID: SW001
Enter Facility Name: Hồ bơi Olimpia
Enter Facility Type: Swimming
Enter Price per Hour: $45.00
```

**Lưu ý:**
- ID phải duy nhất
- Giá phải > 0
- Type nên chuẩn hóa (Tennis, Football, Basketball, Badminton, Swimming...)

#### 1.4 Cập nhật trạng thái cơ sở
```
Menu chính → 1 → 4
```
**Sử dụng khi:**
- Cơ sở đang bảo trì → Set Unavailable
- Cơ sở sẵn sàng lại → Set Available

#### 1.5 Tìm kiếm theo loại
```
Menu chính → 1 → 5
Enter facility type: Tennis
```
- Tìm tất cả cơ sở cùng loại
- Không phân biệt chữ hoa/thường

---

### 📅 PHẦN 2: QUẢN LÝ ĐẶT CHỖ

#### 2.1 Tạo đặt chỗ mới

**Các bước:**

```
Menu chính → 2 → 1
```

**Bước 1: Chọn cơ sở**
```
Enter Facility ID: TC001
```
💡 Xem danh sách cơ sở trước bằng Menu 1→2

**Bước 2: Thông tin khách hàng**
```
Enter Customer Name: Nguyen Van A
Enter Phone Number: 0912345678
```

**Quy tắc:**
- Tên: Ít nhất 2 ký tự, chỉ chữ cái và khoảng trắng
- SĐT: 10-11 chữ số

**Bước 3: Chọn ngày**
```
Enter Booking Date (dd/MM/yyyy): 20/11/2025
```
⚠️ Không thể chọn ngày quá khứ!

**Bước 4: Chọn giờ**
```
Start Hour (6-21): 14
End Hour (15-22): 16
```
⏰ Giờ hoạt động: 06:00 - 22:00

**Bước 5: Xác nhận**
```
=== BOOKING DETAILS ===
Booking ID: BK1001
Customer: Nguyen Van A
...
Total Price: $50.00

Confirm booking? (Y/N): Y
```

✅ Thành công → Nhận Booking ID  
❌ Thất bại → Kiểm tra trùng lịch

---

#### 2.2 Xem tất cả đặt chỗ
```
Menu chính → 2 → 2
```
- Hiển thị cả ACTIVE và CANCELLED
- Dùng để xem lịch sử đầy đủ

#### 2.3 Xem đặt chỗ đang hoạt động
```
Menu chính → 2 → 3
```
- Chỉ hiển thị booking chưa bị hủy
- Dùng để quản lý hiện tại

#### 2.4 Hủy đặt chỗ
```
Menu chính → 2 → 4
Enter Booking ID to cancel: BK1001
Are you sure? (Y/N): Y
```

**Lưu ý:**
- Cần có Booking ID (nhận khi tạo booking)
- Chỉ hủy được booking ACTIVE
- Không thể hoàn tác sau khi hủy

#### 2.5 Tìm kiếm theo tên khách hàng
```
Menu chính → 2 → 5
Enter customer name: Nguyen
```
- Tìm theo tên hoặc một phần tên
- Không phân biệt chữ hoa/thường

**Ví dụ:**
- Tìm "Nguyen" → Tìm được: "Nguyen Van A", "Tran Nguyen B"

#### 2.6 Tìm kiếm theo số điện thoại
```
Menu chính → 2 → 6
Enter phone number: 0912345678
```
- Tìm chính xác hoặc một phần SĐT
- Hữu ích khi khách quên Booking ID

#### 2.7 Xem đặt chỗ theo ngày
```
Menu chính → 2 → 7
Enter date (dd/MM/yyyy): 20/11/2025
```
- Xem lịch của một ngày cụ thể
- Tự động sắp xếp theo giờ
- Chỉ hiển thị booking ACTIVE

**Dùng để:**
- Kiểm tra lịch trước khi đặt
- Xem tình hình hoạt động theo ngày

---

### 📊 PHẦN 3: THỐNG KÊ & BÁO CÁO

#### 3.1 Xem thống kê doanh thu
```
Menu chính → 3 → 1
```

**Hiển thị:**
```
=== REVENUE STATISTICS ===
Total Bookings: 15
Active Bookings: 12
Cancelled Bookings: 3
Total Revenue: $1,250.00
```

**Lưu ý:**
- Doanh thu CHỈ tính booking ACTIVE
- Booking bị hủy KHÔNG tính vào doanh thu

#### 3.2 Xem tổng quan cơ sở
```
Menu chính → 3 → 2
```
- Danh sách tất cả cơ sở
- Trạng thái hiện tại
- Giá cho thuê

#### 3.3 Xem tổng quan đặt chỗ
```
Menu chính → 3 → 3
```
- Tất cả booking (ACTIVE + CANCELLED)
- Chi tiết đầy đủ mỗi booking

---

## LƯU Ý QUAN TRỌNG

### ⚠️ Quy tắc nghiệp vụ

1. **Giờ hoạt động:** 06:00 - 22:00
2. **Không đặt chỗ quá khứ**
3. **Không trùng lịch:** Cùng sân, cùng ngày, giờ chồng lấn
4. **Format ngày:** dd/MM/yyyy (VD: 25/12/2025)
5. **Format giờ:** Số nguyên 0-24

### 🎯 Tips sử dụng hiệu quả

1. **Trước khi đặt:**
   - Xem cơ sở khả dụng (Menu 1→2)
   - Xem lịch theo ngày (Menu 2→7)

2. **Lưu Booking ID:**
   - Ghi lại sau khi tạo booking
   - Cần để hủy hoặc tra cứu

3. **Kiểm tra trùng lịch:**
   - Hệ thống tự động kiểm tra
   - Nếu trùng → Chọn giờ khác

4. **Quản lý cơ sở:**
   - Đóng cơ sở bảo trì bằng Update Status
   - Mở lại khi sẵn sàng

### 🐛 Xử lý lỗi thường gặp

**Lỗi:** "Facility not found!"
- **Nguyên nhân:** Nhập sai ID
- **Giải pháp:** Xem danh sách cơ sở trước

**Lỗi:** "Invalid phone number!"
- **Nguyên nhân:** SĐT không đúng 10-11 số
- **Giải pháp:** Nhập lại, chỉ số, không dấu cách

**Lỗi:** "Cannot book for past dates!"
- **Nguyên nhân:** Chọn ngày quá khứ
- **Giải pháp:** Chọn ngày hôm nay hoặc sau

**Lỗi:** "Time slot already booked!"
- **Nguyên nhân:** Trùng lịch
- **Giải pháp:** Chọn giờ khác hoặc sân khác

**Lỗi:** "Invalid name!"
- **Nguyên nhân:** Tên quá ngắn hoặc có số
- **Giải pháp:** Nhập tên ít nhất 2 ký tự, chỉ chữ

### 📝 Ví dụ kịch bản sử dụng

**Kịch bản 1: Đặt sân tennis**
```
1. Vào Menu 1→2 xem sân tennis khả dụng
2. Thấy TC001 Available
3. Vào Menu 2→7 kiểm tra lịch ngày 25/11
4. Thấy 14:00-16:00 trống
5. Vào Menu 2→1 tạo booking:
   - Facility: TC001
   - Name: Nguyen Van A
   - Phone: 0912345678
   - Date: 25/11/2025
   - Time: 14:00-16:00
6. Confirm → Nhận BK1001
7. Lưu BK1001 để sau này tra cứu/hủy
```

**Kịch bản 2: Hủy booking**
```
1. Vào Menu 2→3 xem booking đang hoạt động
2. Tìm thấy booking cần hủy: BK1001
3. Vào Menu 2→4
4. Nhập BK1001
5. Confirm hủy
6. Kiểm tra lại Menu 2→2 thấy status CANCELLED
```

**Kịch bản 3: Tìm booking khách hàng**
```
Khách gọi: "Em đặt sân tên Nguyen Van A"

1. Vào Menu 2→5
2. Nhập: Nguyen Van A
3. Hiển thị tất cả booking của khách
4. Xác nhận thông tin với khách
```

---

## CÂU HỎI THƯỜNG GẶP (FAQ)

**Q: Có thể đặt nhiều sân cùng lúc không?**
A: Không, mỗi lần chỉ đặt được 1 sân. Muốn đặt nhiều → Tạo nhiều booking.

**Q: Có thể sửa booking sau khi tạo không?**
A: Không, chỉ có thể hủy và tạo mới.

**Q: Tính giá như thế nào?**
A: Giá = Giá/giờ × Số giờ. VD: $25/h × 2h = $50

**Q: Có thể đặt qua đêm không?**
A: Không, giờ tối đa là 22:00.

**Q: Booking ID có ý nghĩa gì?**
A: BK + số (VD: BK1001). Dùng để tra cứu và hủy.

**Q: Làm sao biết sân nào đang trống?**
A: Dùng Menu 2→7 xem theo ngày.

---

## HỖ TRỢ

Nếu gặp vấn đề:
1. Đọc lại hướng dẫn này
2. Kiểm tra file TESTING.md
3. Đảm bảo Java version đúng
4. Kiểm tra encoding UTF-8

---

## PHÍM TẮT

- Nhập số → Chọn menu
- Enter → Xác nhận/Tiếp tục
- Y/N → Yes/No
- 0 → Quay lại menu trước

---

**Chúc bạn sử dụng hệ thống thành công! 🎉**

---

*Version 1.0 - Sports Booking System*  
*Educational Project - Java Console Application*
