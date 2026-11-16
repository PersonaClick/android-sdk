package com.personalization.core

/**
 * The app's callbacks on pushes: for every shop with `PersonaClick.setPushCallbacks`, for one shop with
 * `SDK.setPushCallbacks`. A shop's own callback for an event wins over the facade's for that event.
 *
 * A callback runs on the main thread when the SDK sees its event: its messaging service, a notification
 * it drew, or `PersonaClick.handlePush`. One event of one message (its `code`) is reported once per process.
 * An exception a callback throws is logged as `callback_failed`. All fields are optional;
 * `PushCallbacks()` with none clears them.
 */
class PushCallbacks @JvmOverloads constructor(
    /** The push reached the app. */
    val onDelivered: PushListener? = null,
    /** The notification was shown. */
    val onOpened: PushListener? = null,
    /** The notification was tapped: what to open is [PushPayload.target]; the SDK opens nothing itself. */
    val onClicked: PushListener? = null,
    /** The notification was dismissed without a tap. */
    val onClosed: PushListener? = null,
    /** The SDK got a new token from FCM or HMS, once per token and provider in a process. */
    val onToken: PushTokenListener? = null,
)

/** A push event's callback. */
fun interface PushListener {
    fun onPush(payload: PushPayload)
}

/** A push token's callback. */
fun interface PushTokenListener {
    fun onToken(token: PushToken)
}
