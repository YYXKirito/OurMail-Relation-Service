package com.ourmail.relationservice.domain

import javax.persistence.Entity

@Entity
class Blocklist {
    var id=0L;
    var user=0L;
    var target=0L;
}