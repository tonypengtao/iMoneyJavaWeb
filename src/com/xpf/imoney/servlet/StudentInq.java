package com.xpf.imoney.servlet;

import com.xpf.imoney.bean.Student;
import com.xpf.imoney.cons.StatusHouse;
import com.xpf.imoney.json.ListObject;
import com.xpf.imoney.serviceimpl.StudentServiceImpl;
import com.xpf.imoney.utils.JackJsonUtils;
import com.xpf.imoney.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * @author Vancy
 * Function:
 * @date 2018年5月10日
 */
@WebServlet(name = "StudentInq", urlPatterns = "/student")
public class StudentInq extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInq() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        List<Student> list = new StudentServiceImpl().getAllStudents();
        ListObject listObject = new ListObject();
        listObject.setItems(list);
        listObject.setStatusObject(StatusHouse.COMMON_STATUS_OK);
        String responseText = JackJsonUtils.toJson(listObject);
        ResponseUtils.renderJson(response, responseText);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
