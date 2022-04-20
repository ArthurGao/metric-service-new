package com.parrotanalytics.metrics.service.services;

import java.util.List;

import com.parrotanalytics.metrics.service.apidb_model.nonmanaged.ExtendedNewsArticle;
import com.parrotanalytics.metrics.service.request.news.NewsRequest;
import com.parrotanalytics.apicore.exceptions.APIException;

public interface NewsService
{
    List<ExtendedNewsArticle> findLatestNews(NewsRequest apiRequest) throws APIException;
}
