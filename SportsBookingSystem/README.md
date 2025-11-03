# Sports Booking System

## Giới thiệu (Introduction)
Hệ thống đặt sân thể thao (Sports Booking System) là một ứng dụng console Java giúp quản lý việc đặt chỗ cho các cơ sở thể thao như sân tennis, sân bóng đá, sân bóng rổ, v.v.

A console-based Java application for managing sports facility bookings including tennis courts, football fields, basketball courts, and more.

## Tính năng (Features)

### 1. Quản lý cơ sở vật chất (Facility Management)
- ✅ Xem tất cả các cơ sở
- ✅ Xem các cơ sở khả dụng
- ✅ Thêm cơ sở mới
- ✅ Cập nhật trạng thái cơ sở
- ✅ Tìm kiếm cơ sở theo loại

### 2. Quản lý đặt chỗ (Booking Management)
- ✅ Tạo đặt chỗ mới
- ✅ Xem tất cả đặt chỗ
- ✅ Xem đặt chỗ đang hoạt động
- ✅ Hủy đặt chỗ
- ✅ Tìm kiếm đặt chỗ theo tên khách hàng
- ✅ Tìm kiếm đặt chỗ theo số điện thoại
- ✅ Xem đặt chỗ theo ngày

### 3. Thống kê & Báo cáo (Statistics & Reports)
- ✅ Xem thống kê doanh thu
- ✅ Xem tổng quan cơ sở
- ✅ Xem tổng quan đặt chỗ

## Yêu cầu hệ thống (System Requirements)
- Java Development Kit (JDK) 8 trở lên
- Terminal/Command Prompt hỗ trợ UTF-8 (cho tiếng Việt)

## Cách cài đặt và chạy (Installation & Running)

### Trên Linux/Mac:
```bash
# Cấp quyền thực thi cho script
chmod +x run.sh

# Chạy ứng dụng
./run.sh
```

### Trên Windows:
```batch
# Chạy file batch
run.bat
```

### Chạy thủ công (Manual):
```bash
# Biên dịch
javac -d bin src/*.java src/model/*.java src/manager/*.java src/util/*.java src/view/*.java

# Chạy
cd bin
java Main
```

## Cấu trúc dự án (Project Structure)

```
SportsBookingSystem/
├── src/
│   ├── Main.java                    # Entry point
│   ├── model/                       # Data models
│   │   ├── Facility.java           # Facility entity
│   │   ├── Booking.java            # Booking entity
│   │   └── TimeSlot.java           # Time slot entity
│   ├── manager/                     # Business logic
│   │   ├── FacilityManager.java    # Facility management
│   │   └── BookingManager.java     # Booking management
│   ├── util/                        # Utilities
│   │   ├── Validator.java          # Input validation
│   │   └── InputHandler.java       # Input handling
│   └── view/                        # User interface
│       └── Menu.java                # Menu system
├── bin/                             # Compiled classes
├── run.sh                           # Run script (Linux/Mac)
├── run.bat                          # Run script (Windows)
└── README.md                        # This file
```

## Hướng dẫn sử dụng (User Guide)

### 1. Tạo đặt chỗ mới (Create New Booking)
1. Chọn "Booking Management" từ menu chính
2. Chọn "Create New Booking"
3. Nhập ID cơ sở từ danh sách hiển thị
4. Nhập thông tin khách hàng (tên, số điện thoại)
5. Nhập ngày đặt (định dạng: dd/MM/yyyy)
6. Nhập khung giờ (6:00 - 22:00)
7. Xác nhận đặt chỗ

### 2. Hủy đặt chỗ (Cancel Booking)
1. Chọn "Booking Management" từ menu chính
2. Chọn "Cancel Booking"
3. Nhập Booking ID cần hủy
4. Xác nhận hủy

### 3. Tìm kiếm (Search)
- Tìm theo tên khách hàng: Nhập tên hoặc một phần của tên
- Tìm theo số điện thoại: Nhập số điện thoại hoặc một phần
- Tìm theo ngày: Nhập ngày cụ thể

## Dữ liệu mẫu (Sample Data)

Hệ thống đi kèm với các cơ sở mặc định:
- TC001: Tennis Court 1 - $25/giờ
- TC002: Tennis Court 2 - $25/giờ
- FB001: Football Field A - $50/giờ
- FB002: Football Field B - $50/giờ
- BB001: Basketball Court 1 - $30/giờ
- BM001: Badminton Court 1 - $20/giờ
- BM002: Badminton Court 2 - $20/giờ

## Quy tắc kinh doanh (Business Rules)

1. **Giờ hoạt động**: 06:00 - 22:00
2. **Định dạng ngày**: dd/MM/yyyy (ví dụ: 15/11/2025)
3. **Số điện thoại**: 10-11 chữ số
4. **Tên khách hàng**: Ít nhất 2 ký tự, chỉ chữ cái và khoảng trắng
5. **Đặt chỗ**: Không thể đặt cho ngày quá khứ
6. **Thời gian**: Không được trùng lặp cho cùng một cơ sở

## Xử lý lỗi (Error Handling)

Hệ thống xử lý các lỗi phổ biến:
- ✅ Xác thực đầu vào không hợp lệ
- ✅ Kiểm tra trùng lặp thời gian
- ✅ Xác thực định dạng ngày
- ✅ Xác thực số điện thoại
- ✅ Ngăn chặn đặt chỗ quá khứ

## Tác giả (Author)
Sports Booking System Development Team

## Phiên bản (Version)
1.0 - Initial Release

## Giấy phép (License)
Educational Purpose Only

---

## English Version

### Quick Start
1. Run `./run.sh` (Linux/Mac) or `run.bat` (Windows)
2. Navigate through menus using number keys
3. Follow on-screen prompts
4. Press Enter to continue after each action

### Main Features
- **Facility Management**: Add, view, update facilities
- **Booking System**: Create, cancel, search bookings
- **Statistics**: Revenue reports and summaries
- **Validation**: All inputs are validated
- **User-Friendly**: Clear menus and error messages

### Sample Usage
```
Enter your choice: 2          (Booking Management)
Enter your choice: 1          (Create New Booking)
Enter Facility ID: TC001
Enter Customer Name: John Doe
Enter Phone Number: 0912345678
Enter Booking Date: 15/11/2025
Start Hour: 14
End Hour: 16
Confirm booking? (Y/N): Y
```

### Tips
- Use "View Available Facilities" before booking
- Keep your Booking ID for cancellation
- Check bookings by date to avoid conflicts
- Use search functions to find specific bookings

---

**Chúc bạn sử dụng hệ thống hiệu quả! / Enjoy using the system!**
