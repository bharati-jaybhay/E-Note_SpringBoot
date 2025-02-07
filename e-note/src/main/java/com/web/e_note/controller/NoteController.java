package com.web.e_note.controller;

import com.web.e_note.entity.Notes;
import com.web.e_note.service.NoteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@AllArgsConstructor
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/e-note/add")
    public String showAddNote(Model model){
//        Notes notes= new Notes();
        model.addAttribute("notes", new Notes());
        return "dashboard";
    }

    @PostMapping("/e-note")
    public String saveNote(@Valid @ModelAttribute Notes notes, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            System.out.println(notes);
            return "dashboard";
        }
        noteService.saveNotes(notes);
        redirectAttributes.addFlashAttribute("successMessage", "Your note added successfully");
        return "redirect:/e-note/add";
    }

    @GetMapping("/e-note")
    public String showAllData(Model model){
        List<Notes> notes=noteService.getAllNotes();
        model.addAttribute("allNotes", notes);
        return "all-notes";
    }

    @GetMapping("e-note/view/{id}")
    public String showNoteById(@PathVariable int id, Model model,RedirectAttributes redirectAttributes){
        Notes notes=noteService.getNoteById(id);

        if(notes !=null) {
            model.addAttribute("notes", notes);
            return "show-notes";
        }else {
            redirectAttributes.addFlashAttribute("errorMassage", "your note not found!!");
            return "redirect/:notes";
        }
    }
}
