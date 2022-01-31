package com.epam.controller;

import com.epam.entity.impl.GiftCertificate;
import com.epam.exception.GiftNotFoundException;
import com.epam.service.GiftService;
import com.epam.util.sorting.impl.GiftSqlSorting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gifts")
public class GiftController {

    private final GiftService service;

    @Autowired
    public GiftController(GiftService service) {
        this.service = service;
    }

    @PostMapping(value = "/save")
    public boolean save(@RequestBody GiftCertificate entity) {
        return service.save(entity);
    }

    @GetMapping(value = "/getById/{giftId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GiftCertificate getById(@PathVariable Long giftId) {
        return service.findById(giftId)
                .orElseThrow(() -> new GiftNotFoundException(giftId));
    }

    @GetMapping(value = "/getByName/{giftName}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GiftCertificate getByName(@PathVariable String giftName) {
        return service.findByName(giftName)
                .orElseThrow(() -> new GiftNotFoundException(giftName));
    }

    @GetMapping(value = "/getAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GiftCertificate> getAll() {
        return service.findAll();
    }

    @PostMapping(value = "/update")
    public boolean update(@RequestBody GiftCertificate entity) {
        return service.update(entity);
    }

    @DeleteMapping(value = "/delete/{giftId}")
    public boolean delete(@PathVariable Long giftId) {
        return service.deleteById(giftId);
    }

    @GetMapping(value = "/findByTagId/{tagId}")
    public List<GiftCertificate> findByTagId(@PathVariable Long tagId) {
        return service.findByTagId(tagId);
    }

    @GetMapping(value = "/findByTagIdSorted/{tagId}")
    public List<GiftCertificate> findByTagIdSorted(@PathVariable Long tagId,
                                                   @RequestParam GiftSqlSorting sort) {
        return service.findByTagId(tagId, sort);
    }

    @GetMapping(value = "/findByTagName/{tagName}")
    public List<GiftCertificate> findByTagName(@PathVariable String tagName) {
        return service.findByTagName(tagName);
    }

    @GetMapping(value = "/findByTagNameSorted/{tagName}")
    public List<GiftCertificate> findByTagName(@PathVariable String tagName,
                                               @RequestParam GiftSqlSorting param) {
        return service.findByTagName(tagName, param);
    }

    @GetMapping(value = "/findByPartialName/{partName}")
    public List<GiftCertificate> findByPartialName(@PathVariable String partName) {
        return service.findByPartialName(partName);
    }

    @GetMapping(value = "/findByPartialNameSorted/{partName}")
    public List<GiftCertificate> findByPartialName(@PathVariable String partName,
                                                   @RequestParam GiftSqlSorting param) {
        return service.findByPartialName(partName, param);
    }

    @GetMapping(value = "/findByPartialDesc/{partDesc}")
    public List<GiftCertificate> findByPartialDesc(@PathVariable String partDesc) {
        return service.findByPartialDesc(partDesc);
    }

    @GetMapping(value = "/findByPartialDescSorted/{partDesc}")
    public List<GiftCertificate> findByPartialDesc(@PathVariable String partDesc,
                                                   @RequestParam GiftSqlSorting param) {
        return service.findByPartialDesc(partDesc, param);
    }

    @PostMapping(value = "/addTagToCertificate")
    public boolean addTagToCertificate(@RequestParam Long certId,
                                       @RequestParam String name) {
        return service.addTagToCertificate(certId, name);
    }
}