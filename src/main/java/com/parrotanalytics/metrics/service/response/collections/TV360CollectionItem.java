package com.parrotanalytics.metrics.service.response.collections;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.parrotanalytics.apicore.model.response.APIResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TV360CollectionItem extends APIResponse {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result + ((contextMetric == null) ? 0 : contextMetric.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((marketCapable == null) ? 0 : marketCapable.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((query == null) ? 0 : query.hashCode());
		result = prime * result + ((sortBy == null) ? 0 : sortBy.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((tooltip == null) ? 0 : tooltip.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TV360CollectionItem other = (TV360CollectionItem) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (contentType == null) {
			if (other.contentType != null)
				return false;
		} else if (!contentType.equals(other.contentType))
			return false;
		if (contextMetric == null) {
			if (other.contextMetric != null)
				return false;
		} else if (!contextMetric.equals(other.contextMetric))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (marketCapable == null) {
			if (other.marketCapable != null)
				return false;
		} else if (!marketCapable.equals(other.marketCapable))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (query == null) {
			if (other.query != null)
				return false;
		} else if (!query.equals(other.query))
			return false;
		if (sortBy == null) {
			if (other.sortBy != null)
				return false;
		} else if (!sortBy.equals(other.sortBy))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (tooltip == null) {
			if (other.tooltip != null)
				return false;
		} else if (!tooltip.equals(other.tooltip))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -9217906082100000482L;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("label")
	private String label;

	@JsonProperty("rich_label")
	private String richLabel;

	@JsonProperty("description")
	private String description;

	@JsonProperty("tooltip")
	private String tooltip;

	@JsonProperty("context_metric")
	private String contextMetric;

	@JsonProperty("query")
	private Object query;

	@JsonProperty("sort_by")
	private String sortBy;

	@JsonProperty("source")
	private String source;

	@JsonProperty("type")
	private String type;

	@JsonProperty("content_type")
	private String contentType;

	@JsonProperty("market_capable")
	private Boolean marketCapable;

	@JsonProperty("active")
	private Boolean active;

	@JsonProperty("search_priority")
	private Integer searchPriority;

}
