@file:JvmName("StringHandler")

package sa.hudhud.api.core.handlers

import sa.hudhud.api.core.http.HttpResponse
import sa.hudhud.api.core.http.HttpResponse.Handler

internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        response.body().readBytes().toString(Charsets.UTF_8)
}
