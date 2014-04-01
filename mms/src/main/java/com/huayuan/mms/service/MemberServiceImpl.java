package com.huayuan.mms.service;

import com.huayuan.mms.common.exception.MemberNotFoundException;
import com.huayuan.mms.domain.*;
import com.huayuan.mms.domain.crawler.BillCrawler;
import com.huayuan.mms.repository.IdCardRepository;
import com.huayuan.mms.repository.MemberRepository;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * Created by dell on 14-3-19.
 */
@Service(value = "memberService")
@Transactional
public class MemberServiceImpl implements MemberService {
    @Inject
    private MemberRepository memberRepository;
    private MessageSource messageSource;

    @Resource
    private IdCardRepository idCardRepository;

    @Override
    public void register(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void update(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void updateIdCard(Member member, IdCard idCard) {
        IdCard ic = idCardRepository.findOne(member.getIdCard().getId());
        ic.setIssuer(idCard.getIssuer());
        ic.setValidFrom(idCard.getValidFrom());
        ic.setValidThru(idCard.getValidThru());
        idCardRepository.save(ic);
    }

    @Override
    public Member find(Long id) {
        Member result = memberRepository.findOne(id);
        if (result == null) throw new MemberNotFoundException(id);
        return result;
    }

    @Override
    public void remove(Member member) {
        memberRepository.delete(member);
    }

    @Override
    public void removeIdCard(IdCard idCard) {
        idCardRepository.delete(idCard);
    }

    @Override
    public Iterable<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void addIdCard(Member member, IdCard idCard) {
        idCard.setMember(member);
        member.setIdCard(idCard);
        memberRepository.save(member);
    }

    @Override
    public void addCreditCard(Member member, CreditCard creditCard) {
        member.addCreditCard(creditCard);
        creditCard.setMember(member);
        memberRepository.save(member);
    }

    @Override
    public void addBillMailBox(Member member, BillMailbox billMailbox) {
        BillCrawler crawler = new BillCrawler();
        addBill(member, crawler.crawl(billMailbox));
    }

    @Override
    public void addBill(Member member, Bill bill) {
        member.addBill(bill);
        bill.setMember(member);
        memberRepository.save(member);
    }

    @Override
    public void addPreCredit(Member member, PreCredit credit) {
        member.addPreCredit(credit);
        credit.setMember(member);
        memberRepository.save(member);
    }
}
