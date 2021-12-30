package rcar.samples.springbootmvc.repositories

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

class BaseRepository<T, S>: ElasticsearchRepository<T, S> {

}