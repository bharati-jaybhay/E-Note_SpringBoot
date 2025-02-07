package com.web.e_note.controller;

import com.web.e_note.entity.Notes;
import com.web.e_note.service.NoteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.regex.Pattern;

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
    public String saveNote(@RequestParam(name = "id") String idStr, @Valid @ModelAttribute Notes notes, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            System.out.println(notes);
            return "dashboard";
        }
        String regex="^\\d+$";
        if(Pattern.matches(regex, idStr)) {
            // save to db
            int id = Integer.parseInt(idStr);
            notes.setId(id);
            noteService.saveNotes(notes);
            if (id != 0) {
                redirectAttributes.addFlashAttribute("successMessage", "Your note updated successfully");
                return "redirect:/e-note/view/" + id;
            } else {
                redirectAttributes.addFlashAttribute("successMessage", "Your note added successfully");
                return "redirect:/e-note/add";
            }
        }else {
            redirectAttributes.addFlashAttribute("errorMessage", "Id cannot found!!");
            return "redirect:/notes";
        }
    }

    @GetMapping(value = {"/","/e-note"})
    public String showAllData(Model model){
        List<Notes> notes=noteService.getAllNotes();
        model.addAttribute("allNotes", notes);
        return "all-notes";
    }


    @GetMapping("e-note/view/{id}")
    public String showNoteById(@PathVariable(name = "id") String idStr, Model model,RedirectAttributes redirectAttributes) {
        String regex = "^\\d+$";

        if (Pattern.matches(regex, idStr)) {

            int id = Integer.parseInt(idStr);
            Notes notes = noteService.getNoteById(id);

            if (notes != null) {
                model.addAttribute("notes", notes);
                return "show-notes";
            } else {
                redirectAttributes.addFlashAttribute("errorMassage", "your note not found!!");
                return "redirect/:notes";
            }
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Id cannot be String");
            return "redirect:/notes";
        }
    }

    @GetMapping("/e-note/delete")
    public String deleteNoteById(@RequestParam(name = "id")String idStr, RedirectAttributes redirectAttributes){

        String regex="^\\d+$";
        if(Pattern.matches(regex, idStr)) {
            int id = Integer.parseInt(idStr);
            Notes notes = noteService.getNoteById(id);

            if (notes != null) {
                // delete
                noteService.deleteNoteById(id);
                redirectAttributes.addFlashAttribute("errorMessage", "Note deleted successfully..");
                return "redirect:/notes";
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Your note not found!!");
                return "redirect:/notes";
            }
        }else {
            redirectAttributes.addFlashAttribute("errorMessage","Id cannot be String!!");
            return "redirect:/notes";
        }
    }

    @GetMapping("/e-note/edit")
    public String updateNote(@RequestParam(name = "id") String idStr, RedirectAttributes redirectAttributes, Model model){
        String regex="^\\d+$";
        if(Pattern.matches(regex, idStr)){
            int id=Integer.parseInt(idStr);
            Notes notes=noteService.getNoteById(id);

            if(notes != null){
                model.addAttribute("notes", notes);
                model.addAttribute("btn_name", "Update");
                return "dashboard";
            }else {
                redirectAttributes.addFlashAttribute("errorMessage","your note not found!!");
                return "redirect:/notes";
            }
        }else {
            redirectAttributes.addFlashAttribute("errorMessage","Id cannot be String!!");
            return "redirect:/notes";
        }
    }
}
