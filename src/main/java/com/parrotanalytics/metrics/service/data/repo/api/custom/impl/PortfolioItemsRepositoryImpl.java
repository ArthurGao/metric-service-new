package com.parrotanalytics.metrics.service.data.repo.api.custom.impl;

import com.parrotanalytics.metrics.service.apidb_model.PortfolioItem;
import com.parrotanalytics.metrics.service.data.repo.api.PortfolioItemsRepository;
import com.parrotanalytics.metrics.service.data.repo.api.TitlesRepository;
import com.parrotanalytics.metrics.service.data.repo.api.custom.PortfolioItemsRepositoryCustom;
import com.parrotanalytics.apicore.exceptions.APIException;
import com.parrotanalytics.apicore.model.catalogapi.metadata.CatalogItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * Implementation for custom methods in {@link PortfolioItemsRepositoryCustom}
 * 
 * @author Sanjeev Sharma
 *
 */
public class PortfolioItemsRepositoryImpl implements PortfolioItemsRepositoryCustom
{
    @Autowired
    private PortfolioItemsRepository portfolioItemsRepo;

    @Autowired
    TitlesRepository titlesRepository;

    @Override
    public Page<CatalogItem> findPortfoioTitles(Integer portfolioID) throws APIException
    {
        return titlesRepository.portfolioTitles(portfolioID);
    }

    @Override
    public boolean deleteItem(PortfolioItem item)
    {
        /*
         * Deletes the item from portfolio items
         */
        portfolioItemsRepo.delete(item);

        /*
         * Invalidates items cache for given portfolio
         */
        titlesRepository.invalidatePortfolioTitlesCache(item.getIdPortfolio());

        return true;
    }

}