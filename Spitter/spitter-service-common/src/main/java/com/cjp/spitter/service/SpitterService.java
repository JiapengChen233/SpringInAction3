package com.cjp.spitter.service;

import com.cjp.spitter.domain.Spitter;
import com.cjp.spitter.domain.Spittle;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.annotation.security.RolesAllowed;
import java.util.List;

public interface SpitterService {

    @PreAuthorize("hasRole('ROLE_SPITTER') and #spitter.fullName == 'Ronaldo'")
    void saveSpitter(Spitter spitter);

    Spitter getSpitter(long id);

//    @PostAuthorize("returnObject.username == principal.username")
//    @RolesAllowed("ROLE_SPITTER")
    Spitter getSpitter(String username);

    List<Spitter> getAllSpitters();

    Spittle getSpittleById(long id);

    void saveSpittle(Spittle spittle);

    void deleteSpittle(long id);

    List<Spittle> getRecentSpittles(int count);

    List<Spittle> getSpittlesForSpitter(Spitter spitter);

    @PostFilter("hasPermission(filterObject, 'delete')")
    @Secured("ROLE_SPITTER")
    List<Spittle> getSpittlesForSpitter(String username);

    void startFollowing(Spitter follower, Spitter followee);
}
