package com.ourmail.relationservice.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Blocklist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id=0L;
    var userId=0L;
    var targetId=0L;
}