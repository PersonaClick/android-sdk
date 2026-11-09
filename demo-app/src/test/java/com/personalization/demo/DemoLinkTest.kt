package com.personalization.demo

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

/**
 * The demo tells its links apart in one place: the game link of any of the demos' schemes opens the game
 * here, a stories link (`r46_stories`) stays a stories link, the rest goes on as before.
 */
class DemoLinkTest {

    @Test
    fun `the game host with the scheme of any of the demos is the game`() {
        listOf(
            "personaclick://game",
            "personaclickflutter://game",
            "personaclickrn://game",
            "personaclick://game/",
            "personaclick://game/level/2?from=popup#top",
            "PersonaClick://Game",
            "  personaclick://game  ",
            "personaclick://game:80"
        ).forEach { assertEquals(it, DemoLink.GAME, DemoLink.of(it)) }
    }

    @Test
    fun `a game link with an address is still the game`() {
        assertEquals(DemoLink.GAME, DemoLink.of("personaclick://game?url=https%3A%2F%2Fexample.com%2Fgame"))
        assertEquals(DemoLink.GAME, DemoLink.of("personaclick://game?url=http%3A%2F%2Fexample.com"))
    }

    @Test
    fun `r46_stories makes a stories link, the game host included`() {
        listOf(
            "personaclick://game?r46_stories=abc&r46_story=40",
            "personaclick://demo.personaclick.ru/?r46_stories=abc&r46_story=40&r46_slide=37",
            "https://demo.personaclick.ru/?r46_stories=abc&r46_story=40",
            "personaclick://stories?r46_story=40&r46_stories=abc"
        ).forEach { assertEquals(it, DemoLink.STORIES, DemoLink.of(it)) }
    }

    @Test
    fun `anything else is another link`() {
        listOf(
            "",
            "game",
            "personaclick:game",
            "personaclick://games",
            "personaclick://stories",
            "personaclick://demo.personaclick.ru/game",
            "myapp://game",
            "https://game",
            "https://demo.personaclick.ru/catalog",
            "personaclick://game.example.com",
            "https://demo.personaclick.ru/#r46_stories=abc"
        ).forEach { assertEquals(it, DemoLink.OTHER, DemoLink.of(it)) }
    }

    @Test
    fun `the https address of a game link is decoded`() {
        assertEquals(
            "https://example.com/game?level=2",
            DemoLink.gameAddress("personaclick://game?url=https%3A%2F%2Fexample.com%2Fgame%3Flevel%3D2")
        )
        assertEquals("https://example.com/game", DemoLink.gameAddress("personaclickrn://game?from=popup&url=https://example.com/game"))
        assertEquals("HTTPS://example.com", DemoLink.gameAddress("personaclick://game?url=HTTPS%3A%2F%2Fexample.com"))
    }

    @Test
    fun `an address that is not https or does not parse gives none`() {
        listOf(
            "personaclick://game",
            "personaclick://game?url=",
            "personaclick://game?url=http%3A%2F%2Fexample.com%2Fgame",
            "personaclick://game?url=javascript%3Aalert(1)",
            "personaclick://game?url=file%3A%2F%2F%2Fsdcard%2Fgame.html",
            "personaclick://game?url=https%3A%2F%2F",
            "personaclick://game?url=https%3A%2F%2Fexa%20mple.com",
            "personaclick://game?url=%E0%A4%A",
            "personaclick://game?url=example.com",
            "https://example.com/?url=https%3A%2F%2Fexample.com%2Fgame",
            "personaclick://game?r46_stories=abc&r46_story=40&url=https%3A%2F%2Fexample.com"
        ).forEach { assertNull(it, DemoLink.gameAddress(it)) }
    }
}
