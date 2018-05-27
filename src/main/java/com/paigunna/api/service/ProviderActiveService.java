package com.paigunna.api.service;

import com.paigunna.api.dto.UserDto;

import java.util.List;

public interface ProviderActiveService {

    List<UserDto> findActiveProvider();
}
