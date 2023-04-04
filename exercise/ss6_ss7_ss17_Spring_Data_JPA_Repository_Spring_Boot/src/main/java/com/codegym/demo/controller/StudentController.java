package com.codegym.demo.controller;

import com.codegym.demo.model.Student;
import com.codegym.demo.service.IClassRoomService;
import com.codegym.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("student")
public class StudentController {

    //DI
    @Autowired
    @Qualifier("studentService")
    private IStudentService iStudentService;

    @Autowired
    private IClassRoomService iClassRoomService;

    @GetMapping(value = "")
//    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showListStudent(Model model) {
        model.addAttribute("listStudent", iStudentService.getAll());
        return "list_student";
    }

    @GetMapping("create")
    public String showPageCreate(Model model) {
        model.addAttribute("student", new Student());
//        String[] nameClasses = new String[]{"C1122G1", "C1222G1", "C1022G1"};
        model.addAttribute("classes", iClassRoomService.findAll());
        return "create_student";
    }

    @PostMapping("create")
    public String createStudent(
            @ModelAttribute Student student,
            BindingResult bindingResult,
            RedirectAttributes redirect
    ) {
        iStudentService.save(student);
        redirect.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/student";
    }

//    @PostMapping("create")
//    public String createStudent(
//            @RequestParam("codeStudent") int code,
//            @RequestParam String nameStudent,
//            @RequestParam Double point,
//            @RequestParam Integer gender,
//            RedirectAttributes redirect
//    ) {
//        iStudentService.save(new Student(code, nameStudent, point, gender));
//        redirect.addFlashAttribute("msg", "Thêm mới thành công");
//        return "redirect:/student";
//    }



    @GetMapping("detail/{id}")
    public String detailStudent(@PathVariable("id") int codeStudent,
                                Model model) {
        Student student = iStudentService.getStudentById(codeStudent);
        model.addAttribute("student", student);
        return "detail_student";
    }
}
