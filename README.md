# VisitorFlow
VisitorFlow is a web application with separate sections for admin and visitor functionality. The project allows administrators to manage visitor records and gatepass applications, while visitors can apply for gatepasses and receive access to services using a unique QR code and ID on registered email id.

Features

### Admin Section:  

* Admin Registration & Login:
  Admins can create an account and log in to access the admin panel.
* View All Visitor Records:
  Admin can view all registered visitor details.
* Block Visitors:
  Admin can block specific visitors to restrict their access.
* Blocklist Management:
  Admin can view a list of blocked visitors and unblock them if needed.


### Visitor Section:

* Gatepass Application:
 Visitors can apply for a gatepass through the portal.
* QR Code & Unique ID Generation:
 Upon successful application, the visitor receives a confirmation email with a QR code and unique ID.
* Service Access:
 Visitors can use the QR code and unique ID to access services.

### Technologies Used:

* Backend: Java (Servlets, JSP)
* Frontend: HTML, CSS
* Database: MySQL
* Email: JavaMail API for sending emails with QR code and unique ID
* QR Code Generation: ZXing library
