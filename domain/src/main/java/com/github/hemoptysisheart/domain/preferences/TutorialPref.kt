package com.github.hemoptysisheart.domain.preferences

/**
 * 튜토리얼 설정.
 */
interface TutorialPref {
    /**
     * 앱을 실행할 때 튜토리얼을 실행할지 여부.
     * `true`면 튜토리얼 실행.
     */
    var enable: Boolean
}
