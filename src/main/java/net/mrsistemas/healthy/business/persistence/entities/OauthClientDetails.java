package net.mrsistemas.healthy.business.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@Entity(name = "Oauth_Client_Details")
public class OauthClientDetails {

    @Id
    @Getter
    @Setter
    private String client_id;
    @Getter
    @Setter
    private String resource_ids;
    @Getter
    @Setter
    private String client_secret;
    @Getter
    @Setter
    private String scope;
    @Getter
    @Setter
    private String authorized_grant_types;
    @Getter
    @Setter
    private String web_server_redirect_uri;
    @Getter
    @Setter
    private String authorities;
    @Getter
    @Setter
    private String access_token_validity;
    @Getter
    @Setter
    private String refresh_token_validity;
    @Getter
    @Setter
    private String additional_information;
    @Getter
    @Setter
    private String autoapprove;

}
