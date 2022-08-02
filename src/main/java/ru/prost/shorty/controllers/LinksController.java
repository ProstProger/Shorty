package ru.prost.shorty.controllers;

import org.springframework.web.bind.annotation.*;
import ru.prost.shorty.dao.LinkDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.prost.shorty.links.Link;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/links")
public class LinksController {

    private final LinkDAO linkDAO;

    public LinksController(LinkDAO linkDAO) {
        this.linkDAO = linkDAO;
    }

//    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
//    public void method(HttpServletResponse httpServletResponse) {
//        httpServletResponse.setHeader("Location", projectUrl);
//        httpServletResponse.setStatus(302);
//    }

    @GetMapping()
    public String index(Model model) {
        // Получим все линки из DAO и передадим на отображение в представление
        model.addAttribute("allLinks", linkDAO.index());
        return "links/index";
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        //  Получим один линк по id из DAO и передадим на отображение в представление
//        model.addAttribute("link", linkDAO.show(id));
//        return "links/show";
//    }

    @GetMapping("/{id}")
    public String redirect(@ModelAttribute("link") Link link, Model model) {
        //  Получим один линк по id из DAO и передадим на отображение в представление
        model.addAttribute("link", linkDAO.redirect(link.getId()));
        return "redirect:/links/new";// + link.getLongLink();
    }

    @GetMapping("/new")
    public String newLink(Model model){
        model.addAttribute("link", new Link());
        return "links/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("link") Link link){
        linkDAO.save(link);
        return "redirect:/links";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("link", linkDAO.show(id));
            return "links/edit";
    }

//    @PostMapping("/new")
//    public String cut(@ModelAttribute("link") Link link, @PathVariable("id") int id){
//        linkDAO.cut(id, link);
//        return "redirect:/links";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("link") Link link, @PathVariable("id") int id) {
//        linkDAO.update(id, link);
//        return  "redirect:/links";
//    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        linkDAO.delete(id);
        return "redirect:/links";
    }

}
