package net.mrsistemas.healthy.business.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oauth_client_details database table.
 * 
 */
@Entity
@Table(name="oauth_client_details")
@NamedQuery(name="OauthClientDetails.findAll", query="SELECT o FROM OauthClientDetails o")
public class OauthClientDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="client_id")
	private String clientId;

	@Column(name="access_token_validity")
	private Integer accessTokenValidity;

	@Column(name="additional_information")
	private String additionalInformation;

	private String authorities;

	@Column(name="authorized_grant_types")
	private String authorizedGrantTypes;

	private String autoapprove;

	@Column(name="client_secret")
	private String clientSecret;

	@Column(name="refresh_token_validity")
	private Integer refreshTokenValidity;

	@Column(name="resource_ids")
	private String resourceIds;

	private String scope;

	@Column(name="web_server_redirect_uri")
	private String webServerRedirectUri;

	public OauthClientDetails() {
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Integer getAccessTokenValidity() {
		return this.accessTokenValidity;
	}

	public void setAccessTokenValidity(Integer accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	public String getAdditionalInformation() {
		return this.additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public String getAuthorizedGrantTypes() {
		return this.authorizedGrantTypes;
	}

	public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	public String getAutoapprove() {
		return this.autoapprove;
	}

	public void setAutoapprove(String autoapprove) {
		this.autoapprove = autoapprove;
	}

	public String getClientSecret() {
		return this.clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public Integer getRefreshTokenValidity() {
		return this.refreshTokenValidity;
	}

	public void setRefreshTokenValidity(Integer refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}

	public String getResourceIds() {
		return this.resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	public String getScope() {
		return this.scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getWebServerRedirectUri() {
		return this.webServerRedirectUri;
	}

	public void setWebServerRedirectUri(String webServerRedirectUri) {
		this.webServerRedirectUri = webServerRedirectUri;
	}

}