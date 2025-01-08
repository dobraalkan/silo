package com.silo.backend.command.infrastructure.base.security;


import com.silo.backend.command.infrastructure.domain.command.Command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractAuthorizeCommand implements Command, Authorize {

}
