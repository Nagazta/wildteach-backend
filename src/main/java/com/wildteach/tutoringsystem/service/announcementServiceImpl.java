package com.wildteach.tutoringsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wildteach.tutoringsystem.entity.announcementEntity;
import com.wildteach.tutoringsystem.repository.announcementRepository;

@Service
public class announcementServiceImpl implements announcementService {

    @Autowired
    private announcementRepository announcementRepository;

    @Override
    public announcementEntity saveAnnouncement(announcementEntity announcement) {
        return announcementRepository.save(announcement);
    }

    @Override
    public List<announcementEntity> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    @Override
    public announcementEntity getAnnouncementById(Long id) {
        return announcementRepository.findById(id).orElse(null);
    }

    @Override
    public announcementEntity updateAnnouncement(Long id, announcementEntity announcementDetails) {
        announcementEntity announcement = announcementRepository.findById(id).orElse(null);
        if (announcement != null) {
            announcement.setMessage(announcementDetails.getMessage());
            announcement.setCreated_at(announcementDetails.getCreated_at());
            return announcementRepository.save(announcement);
        }
        return null;
    }

    @Override
    public announcementEntity deleteAnnouncement(Long id) {
        announcementEntity announcement = announcementRepository.findById(id).orElse(null);
        if (announcement != null) {
            announcementRepository.deleteById(id);
        }
        return announcement;
    }
}
