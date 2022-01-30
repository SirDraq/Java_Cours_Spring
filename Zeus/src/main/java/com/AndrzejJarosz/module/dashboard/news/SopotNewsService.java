package com.AndrzejJarosz.module.dashboard.news;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SopotNewsService implements NewsService {
    @Override
    public List<String> getLastNews() {
        return List.of(
                "News 1 Sopot",
                "News 2 Sopot",
                "News 3 Sopot"
        );
    }
}
