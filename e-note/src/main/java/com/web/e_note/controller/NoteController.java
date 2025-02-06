package com.web.e_note.controller;

import com.web.e_note.entity.Notes;
import com.web.e_note.service.NoteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class NoteController {

    private NoteService noteService;

    @GetMapping("/note/add")
    public String showAddNote(Model model){
        Notes notes= new Notes();
        model.addAttribute("notes", notes);
        return "note-form";
    }

    @PostMapping("/note")
    public String saveNote(@Valid @ModelAttribute Notes notes, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            System.out.println(notes);
            return "note-form";
        }
        noteService.saveNotes(notes);
        redirectAttributes.addFlashAttribute("successMessage", "Your note added successfully");
        return "redirect:/note/add";
    }

}
