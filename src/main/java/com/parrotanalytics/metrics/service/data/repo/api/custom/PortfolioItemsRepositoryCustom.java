package com.parrotanalytics.metrics.service.data.repo.api.custom;

import com.parrotanalytics.metrics.service.apidb_model.PortfolioItem;
import com.parrotanalytics.apicore.exceptions.APIException;
import com.parrotanalytics.apicore.model.catalogapi.metadata.CatalogItem;
import org.springframework.data.domain.Page;

/**
 * Interface for custom methods in {@link PortfolioItemsRepositoryCustom}.
 * 
 * @author Sanjeev Sharma
 * @since v1
 *
 */
public interface PortfolioItemsRepositoryCustom
{
    /**
     * Deletes portfolio item and invalidates titles cache for given
     * portfolio @see {@link TitlesRepositoryCustom}
     * 
     * @param item
     * @return
     */
    boolean deleteItem(PortfolioItem item);

    /**
     * Find portfolio items as titles for given portfolio
     * 
     * @param portfolioID
     * @return
     * @throws APIException
     */
    Page<CatalogItem> findPortfoioTitles(Integer portfolioID) throws APIException;
}
