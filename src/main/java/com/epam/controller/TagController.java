package com.epam.controller;

import com.epam.entity.impl.Tag;
import com.epam.exception.TagNotFoundException;
import com.epam.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    private final TagService service;

    @Autowired
    public TagController(TagService service) {
        this.service = service;
    }

    @PostMapping(value = "/save")
    public boolean save(@RequestBody Tag entity) {
        return service.save(entity);
    }

    @GetMapping(value = "/findById/{tagId}")
    public Tag findById(@PathVariable Long tagId) {
        return service.findById(tagId)
                .orElseThrow(() -> new TagNotFoundException(tagId));
    }

    @GetMapping(value = "/findByName/{tagName}")
    public Tag findByName(@PathVariable String tagName) {
        return service.findByName(tagName)
                .orElseThrow(() -> new TagNotFoundException(tagName));
    }

    @GetMapping(value = "/findAll")
    public List<Tag> findAll() {
        return service.findAll();
    }

    @PostMapping(value = "/update")
    public boolean update(@RequestBody Tag entity) {
        return service.update(entity);
    }

    @DeleteMapping(value = "/deleteById/{tagId}")
    public boolean deleteById(@PathVariable Long tagId) {
        return service.deleteById(tagId);
    }

    @GetMapping(value = "/findByGiftId/{giftId}")
    public List<Tag> findByGiftId(@PathVariable Long giftId) {
        return service.findByGiftId(giftId);
    }

    @GetMapping(value = "/findByGiftName/{giftName}")
    public List<Tag> findByGiftName(@PathVariable String giftName) {
        return service.findByGiftName(giftName);
    }
}