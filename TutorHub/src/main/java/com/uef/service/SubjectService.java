/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.service;

import com.uef.model.Subject;
import com.uef.model.Use;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

/**
 *
 * @author qnhat
 */
@Service
public class SubjectService {

    private final AtomicInteger idGenerator = new AtomicInteger(1);
    private final List<Subject> subjectList = new ArrayList<>();

    @PostConstruct
    public void init() {
        add(new Subject(0, "Toan", "Tinh toan va lam phep tinh"));
        add(new Subject(0, "Ngu van", "Nghien cuu ve van hoc"));
        add(new Subject(0, "Hoa hoc", "Nghien cuu ve hoa hoc"));
    }

    // Add new Subject
    public void add(Subject subject) {
        subject.setSubId(idGenerator.getAndIncrement());
        subjectList.add(subject);
    }

    //Get All Clients
    public List<Subject> findAll() {
        List<Subject> temp = new ArrayList<>();
        for (int i = 0; i < subjectList.size(); i++){
            if(subjectList.get(i).getUse() == Use.Yes){
                temp.add(subjectList.get(i));
            }
        }
        return temp;
    }

    //Search by ID
    public Subject findById(int SubId) {
        return subjectList.stream()
                .filter(s -> s.getSubId() == SubId)
                .findFirst()
                .orElse(null);
    }

    // Update Subject information
    public void update(Subject subject) {
        for (int i = 0; i < subjectList.size(); i++) {
            if (subjectList.get(i).getSubId() == subject.getSubId()) {
                subjectList.set(i, subject);
                return;
            }
        }
    }

    // Delete by Id
    public void deleteByid(int SubId) {
        // Delete
//        subjectList.removeIf(s -> s.getSubId() == SubId);

        // Hide
        for (int i = 0; i < subjectList.size(); i++) {
            if (subjectList.get(i).getSubId() == SubId) {
                subjectList.get(i).setUse(Use.No);
                return;
            }
        }
    }
    
    // Search by name or description
    public List<Subject> search(String keyword){
        if(keyword == null || keyword.isBlank()){
            return subjectList;
        }
        
        return subjectList.stream()
                .filter(s -> s.getSu_Name().toLowerCase().contains(keyword.toLowerCase())
                || s.getSu_Description().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    // Get the list by pagination
    public List <Subject> getPage(List<Subject> list, int page, int size){
        int from = (page - 1) * size;
        int to =  Math.min(from + size, list.size());
        if(from >= list.size()){
            return new  ArrayList<>();
        }
        return list.subList(from, to);
    }
    
    // Caculate the number of pages needed
    
    public int countPages(List<Subject> list, int size){
        return (int) Math.ceil((double) list.size() / size);
    }
}
