package com.silo.backend.command.infrastructure.bus.base.security;


import com.silo.backend.command.infrastructure.domain.query.Query;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractAuthorizeQuery implements Query {

}
