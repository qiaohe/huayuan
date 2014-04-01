package com.huayuan.mms.domain.crawler;

import com.huayuan.mms.domain.Bill;
import com.huayuan.mms.domain.BillMailbox;

import javax.mail.Session;
import javax.mail.Store;

/**
 * Created by dell on 14-3-21.
 */
public class BillCrawler {

    /**
     *
     * @param billMailbox
     * @return
     */
    public Bill crawl(BillMailbox billMailbox) {

        return new Bill();
    }
}
