import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/StudentReportServlet")
public class StudentReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        int[] marks = new int[5];
        int total = 0;

        for (int i = 0; i < 5; i++) {
            marks[i] = Integer.parseInt(req.getParameter("sub" + (i + 1)));
            total += marks[i];
        }

        double percentage = total / 5.0;
        String grade;
        if (percentage >= 90) grade = "A";
        else if (percentage >= 80) grade = "B";
        else if (percentage >= 70) grade = "C";
        else if (percentage >= 60) grade = "D";
        else if (percentage >= 50) grade = "E";
        else grade = "F";

        String status = (percentage >= 40) ? "PASS" : "FAIL";

        out.println("<!DOCTYPE html><html><head><title>Student Report</title>");
        out.println("<style>body{font-family:Arial;background:#f0f2f5;text-align:center;}");
        out.println(".report{background:#fff;margin:50px auto;padding:20px;border-radius:12px;width:400px;box-shadow:0 2px 8px rgba(0,0,0,0.2);}</style>");
        out.println("</head><body>");
        out.println("<div class='report'>");
        out.println("<h2>Student Report</h2>");
        out.println("<p>Total Marks: " + total + "</p>");
        out.println(String.format("<p>Percentage: %.2f%%</p>", percentage));
        out.println("<p>Grade: " + grade + "</p>");
        out.println("<p>Status: <b>" + status + "</b></p>");
        out.println("<a href='student.html'>Enter Another Student</a>");
        out.println("</div></body></html>");
    }
}
