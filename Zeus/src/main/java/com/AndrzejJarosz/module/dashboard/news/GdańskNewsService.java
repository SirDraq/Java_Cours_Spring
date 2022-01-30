package com.AndrzejJarosz.module.dashboard.news;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GdańskNewsService implements NewsService {
    @Override
    public List<String> getLastNews() {
        return List.of(
                "News 1 Gdansk",
                "News 2 Gdansk",
                "News 3 Gdansk"
        );
    }
}
