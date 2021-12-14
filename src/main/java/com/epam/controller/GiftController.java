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
public class GiftController {

    private final GiftService service;

    @Autowired
    public GiftController(GiftService service) {
        this.service = service;
    }

    @PostMapping(value = "/saveGift")
    public boolean save(@RequestParam GiftCertificate entity) {
        return service.save(entity);
    }

    @GetMapping(value = "/getGiftById/{giftId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GiftCertificate getById(@PathVariable Long giftId) {
        return service.findById(giftId)
                .orElseThrow(() -> new GiftNotFoundException(giftId));
    }

    @GetMapping(value = "/getGiftByName/{giftName}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public GiftCertificate getByName(@PathVariable String giftName) {
        return service.findByName(giftName)
                .orElseThrow(() -> new GiftNotFoundException(giftName));
    }

    @GetMapping(value = "/getAllGifts",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<GiftCertificate> getAll() {
        return service.findAll();
    }

    @PostMapping(value = "/updateGift")
    public boolean update(@RequestBody GiftCertificate entity) {
        return service.update(entity);
    }

    @PostMapping(value = "/deleteGift/{giftId}")
    public boolean delete(@PathVariable Long giftId) {
        return service.deleteById(giftId);
    }

    @GetMapping(value = "/findGiftByTagId/{tagId}")
    @ResponseBody
    public List<GiftCertificate> findByTagId(@PathVariable Long tagId) {
        return service.findByTagId(tagId);
    }

    @GetMapping(value = "/findGiftByTagIdSorted/{tagId}")
    @ResponseBody
    public List<GiftCertificate> findByTagIdSorted(@PathVariable Long tagId,
                                                   @RequestParam GiftSqlSorting sort) {
        return service.findByTagId(tagId, sort);
    }

    @GetMapping(value = "/findGiftByTagName/{tagName}")
    @ResponseBody
    public List<GiftCertificate> findByTagName(@PathVariable String tagName) {
        return service.findByTagName(tagName);
    }

    @GetMapping(value = "/findGiftByTagNameSorted/{tagName}")
    @ResponseBody
    public List<GiftCertificate> findByTagName(@PathVariable String tagName,
                                               @RequestParam GiftSqlSorting param) {
        return service.findByTagName(tagName, param);
    }

    @GetMapping(value = "/findGiftByPartialName/{partName}")
    @ResponseBody
    public List<GiftCertificate> findByPartialName(@PathVariable String partName) {
        return service.findByPartialName(partName);
    }

    @GetMapping(value = "/findGiftByPartialNameSorted/{partName}")
    @ResponseBody
    public List<GiftCertificate> findByPartialName(@PathVariable String partName,
                                                   @RequestParam GiftSqlSorting param) {
        return service.findByPartialName(partName, param);
    }

    @GetMapping(value = "/findGiftByPartialDesc/{partDesc}")
    @ResponseBody
    public List<GiftCertificate> findByPartialDesc(@PathVariable String partDesc) {
        return service.findByPartialDesc(partDesc);
    }

    @GetMapping(value = "/findGiftByPartialDescSorted/{partDesc}")
    @ResponseBody
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
