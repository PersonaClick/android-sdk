package com.personalization

/**
 * An error in the app's code when it looks up an instance through [PersonaClick]: thrown at once, never
 * passed through `SdkError`. Still an [IllegalStateException], as both kinds always were.
 */
sealed class PersonaClickError(message: String) : IllegalStateException(message)

/**
 * Thrown by [PersonaClick.instance] when the requested shop is unknown to the SDK — neither a live
 * instance nor a pending registration exists for it, so there is no config to build one from. A
 * shop that is registered-but-not-yet-initialized does not raise this: `instance` materializes it.
 * The name is deliberate: the failure is a missing registration, not an instance that was registered
 * but failed to start.
 */
class UnknownShopIdException(message: String) : PersonaClickError(message)

/**
 * Thrown by [PersonaClick.instance] called without a `shopId` while more than one shop is registered.
 * The default instance is ambiguous — call `instance(shopId)` with an explicit id.
 */
class AmbiguousShopException(message: String) : PersonaClickError(message)
