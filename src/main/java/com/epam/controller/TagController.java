package com.epam.controller;

import com.epam.entity.impl.Tag;
import com.epam.exception.TagNotFoundException;
import com.epam.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {

    private final TagService service;

    @Autowired
    public TagController(TagService service) {
        this.service = service;
    }

    @PostMapping(value = "/saveTag")
    public boolean save(@RequestBody Tag entity) {
        return service.save(entity);
    }

    @GetMapping(value = "/findTagById/{tagId}")
    @ResponseBody
    public Tag findById(@PathVariable Long tagId) {
        return service.findById(tagId)
                .orElseThrow(() -> new TagNotFoundException(tagId));
    }

    @GetMapping(value = "/findTagByName/{tagName}")
    @ResponseBody
    public Tag findByName(@PathVariable String tagName) {
        return service.findByName(tagName)
                .orElseThrow(() -> new TagNotFoundException(tagName));
    }

    @GetMapping(value = "/findAllTags")
    @ResponseBody
    public List<Tag> findAll() {
        return service.findAll();
    }

    @PostMapping(value = "/updateTag")
    public boolean update(@RequestBody Tag entity) {
        return service.update(entity);
    }

    @PostMapping(value = "/deleteTagById/{tagId}")
    public boolean deleteById(@PathVariable Long tagId) {
        return service.deleteById(tagId);
    }

    @GetMapping(value = "/findTagByGiftId/{giftId}")
    @ResponseBody
    public List<Tag> findByGiftId(@PathVariable Long giftId) {
        return service.findByGiftId(giftId);
    }

    @GetMapping(value = "/findTagByGiftName/{giftName}")
    @ResponseBody
    public List<Tag> findByGiftName(@PathVariable String giftName) {
        return service.findByGiftName(giftName);
    }
}
