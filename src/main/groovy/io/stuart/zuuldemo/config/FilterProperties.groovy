package io.stuart.zuuldemo.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Component
@Configuration
class FilterProperties {

    boolean getEnabled() {
        return enabled
    }

    void setEnabled(boolean enabled) {
        this.enabled = enabled
    }
    @Value('${zuul.filters.requestuuidheader.enabled:false}')
    private boolean enabled

}
