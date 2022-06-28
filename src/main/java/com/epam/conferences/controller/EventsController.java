package com.epam.conferences.controller;

import com.epam.conferences.entity.event.Event;
import com.epam.conferences.entity.user.User;
import com.epam.conferences.service.EventService;
import com.epam.conferences.service.UserService;
import org.fed333.servletboot.annotation.*;
import org.fed333.servletboot.dispatcher.HttpMethod;
import org.fed333.servletboot.web.Model;
import org.fed333.servletboot.web.data.page.Page;
import org.fed333.servletboot.web.data.pageable.Pageable;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class EventsController {
    @Inject
    private EventService eventService;
    @Inject
    private UserService userService;

    @RequestMapping(url = "/events",method = HttpMethod.GET)
    public String events(Model model, HttpSession session,
                         @PageableDefault(size = 10) Pageable pageable,
                         @RequestParam(name = "sort",defaultValue = "") String sort,
                         @RequestParam(name = "page",required = false) Integer page){
        User user = (User) session.getAttribute("user");
        //if(user == null) return "redirect:/login";
        model.addAttribute("user", user);
        Page<Event> pageablePage = eventService.getListOfEvents(pageable, sort);
        model.addAttribute("user",user);
        model.addAttribute("eventList",pageablePage);
        model.addAttribute("sort", sort);
        int totalPages = pageablePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "events.jsp";
    }
}
