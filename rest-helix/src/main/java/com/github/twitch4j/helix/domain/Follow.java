package com.github.twitch4j.helix.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Follow
 */
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Follow {

    /** ID of the user following the to_id user. */
    private String fromId;

    /** Login name corresponding to from_id. */
    private String fromName;

    /** ID of the user being followed by the from_id user. */
    private String toId;

    /** Login name corresponding to to_id. */
    private String toName;

    /** Date and time when the from_id user followed the to_id user. */
    @JsonProperty("followed_at")
    private Instant followedAtInstant;

    /**
     * @return the date and time when the from_id user followed the to_id user.
     * @deprecated in favor of getFollowedAtInstant
     */
    @JsonIgnore
    @Deprecated
    public LocalDateTime getFollowedAt() {
        return LocalDateTime.ofInstant(followedAtInstant, ZoneOffset.UTC);
    }

}
