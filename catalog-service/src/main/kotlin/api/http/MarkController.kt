package ru.yusdm.monolithtomicro.catalog.api.http

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.yusdm.monolithtomicro.catalog.dto.CreateMarkCommandDTO
import ru.yusdm.monolithtomicro.catalog.dto.MarkDTO
import java.util.*

@RestController
@RequestMapping("/api/mark")
class MarkController(private val markHttpService: MarkHttpService) {

    @PostMapping
    fun save(@RequestBody createMarkCommand: CreateMarkCommandDTO): ResponseEntity<MarkDTO> {
        return markHttpService.save(createMarkCommand)
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<MarkDTO>> {
        return markHttpService.finaAll()
    }

    @PutMapping
    fun addModelToMark() {
        markHttpService.addModelToMark(UUID.randomUUID(), "name_" + System.currentTimeMillis() % 15)
    }

}