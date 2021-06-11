package com.cjp.spitter.security;

import com.cjp.spitter.domain.Spittle;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

public class SpittlePermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if (targetDomainObject instanceof Spittle) {
            Spittle spittle = (Spittle) targetDomainObject;
            if ("delete".equals(permission)) {
                return spittle.getSpitter().getUsername().equals(authentication.getName());
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
