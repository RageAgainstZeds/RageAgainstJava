package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveDataServlet extends HttpServlet {

    //fake DB with folks
    private static List<String> nameList = new ArrayList<>();
    private static List<String> surnameList = new ArrayList<>();
    private static List<Integer> ageList = new ArrayList<>();

    //1st question
    private static int qOneBlue =  0;
    private static int qOneRed =  0;

    //2nd question
    private static int qTwoYes =  0;
    private static int qTwoNo =  0;

    //3rd question
    private static int qThreeYes =  0;
    private static int qThreeNo =  0;

    public static int getqOneBlue() {
        return qOneBlue;
    }

    public static int getqOneRed() {
        return qOneRed;
    }

    public static int getqTwoYes() {
        return qTwoYes;
    }

    public static int getqTwoNo() {
        return qTwoNo;
    }

    public static int getqThreeYes() {
        return qThreeYes;
    }

    public static int getqThreeNo() {
        return qThreeNo;
    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        nameList.add(request.getParameter("name"));
        surnameList.add(request.getParameter("surname"));
        ageList.add(Integer.valueOf(request.getParameter("age")));

        System.err.println("request.getParameter -->>" + request.getParameter("question1"));
        System.err.println("request.getParameter(name) -->>" + request.getParameter("name"));

        if (request.getParameter("question1").equalsIgnoreCase("blue"))
            qOneBlue++;
        if (request.getParameter("question1").equalsIgnoreCase("red"))
            qOneRed++;

        if (request.getParameter("question2").equalsIgnoreCase("yes"))
            qTwoYes++;
        if (request.getParameter("question2").equalsIgnoreCase("no"))
            qTwoNo++;

        if (request.getParameter("question3").equalsIgnoreCase("yes"))
            qThreeYes++;
        if (request.getParameter("question3").equalsIgnoreCase("no"))
            qThreeNo++;

        response.sendRedirect("result.jsp");
    }
}
