<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration</title>
    <!-- Removed Tailwind CDN and Google Fonts; using inline styles below -->
    <style>
        /* Basic local font fallback */
        body { font-family: Inter, system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif; }
    </style>
</head>
<body style="background:#f1f5f9;display:flex;align-items:center;justify-content:center;min-height:100vh;margin:0;padding:36px;">
    <div style="background:#ffffff;padding:32px;border-radius:16px;box-shadow:0 10px 25px rgba(15,23,42,0.06);width:100%;max-width:420px;border:1px solid #f1f5f9;">
        <div style="margin-bottom:32px;">
            <h2 style="font-size:1.5rem;font-weight:700;color:#0f172a;margin:0;">Student Registration</h2>
            <p style="color:#64748b;font-size:0.875rem;margin-top:6px;">Enter student details to add them to the database.</p>
        </div>

        <form action="register" method="POST" style="display:block;gap:20px;">
            <div style="margin-bottom:12px;">
                <label style="display:block;font-size:0.875rem;font-weight:600;color:#334155;margin-bottom:6px;">Full Name</label>
                <input type="text" name="name" required placeholder="John Doe"
                    style="width:100%;padding:10px 16px;border-radius:8px;border:1px solid #e6eef6;outline:none;box-sizing:border-box;">
            </div>

            <div style="margin-bottom:12px;">
                <label style="display:block;font-size:0.875rem;font-weight:600;color:#334155;margin-bottom:6px;">Email Address</label>
                <input type="email" name="email" required placeholder="john@university.edu"
                    style="width:100%;padding:10px 16px;border-radius:8px;border:1px solid #e6eef6;outline:none;box-sizing:border-box;">
            </div>

            <div style="margin-bottom:12px;">
                <label style="display:block;font-size:0.875rem;font-weight:600;color:#334155;margin-bottom:6px;">Academic Year</label>
                <input type="number" name="year" required placeholder="2024"
                    style="width:100%;padding:10px 16px;border-radius:8px;border:1px solid #e6eef6;outline:none;box-sizing:border-box;">
            </div>

            <button type="submit" 
                style="width:100%;background:#4f46e5;color:#fff;font-weight:600;padding:12px;border-radius:10px;border:none;cursor:pointer;">
                Register Student
            </button>
        </form>

        <div style="margin-top:24px;padding-top:24px;border-top:1px solid #f1f5f9;text-align:center;">
            <a href="show_all" style="color:#4f46e5;text-decoration:none;font-size:0.875rem;font-weight:600;">View All Registered Students →</a>
        </div>
    </div>
</body>
</html>