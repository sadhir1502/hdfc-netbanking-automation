package com.backbase.hdfc.configuration;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Credentials {

    private String userName;

    private String password;
}
