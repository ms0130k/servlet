package org.shock;

import org.shock.calculator.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    public static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        log.info("service");
        int operand1 = Integer.parseInt(req.getParameter("operand1"));
        int operand2 = Integer.parseInt(req.getParameter("operand2"));
        String operator = req.getParameter("operator");

        double result = Calculator.calculate(operand1, operand2, operator);

        PrintWriter writer = resp.getWriter();
        writer.println(result);
    }
}
