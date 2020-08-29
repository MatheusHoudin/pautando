package com.uds.pautando.features.create_meeting_agenda.data.models;

import com.uds.pautando.core.error.exception.DescriptionAndAuthorNotProvidedException;
import com.uds.pautando.core.error.exception.DescriptionAndDetailsAndAuthorNotProvidedException;
import com.uds.pautando.core.error.exception.DescriptionAndDetailsNotProvidedException;
import com.uds.pautando.core.error.exception.DetailsAndAuthorNotProvidedException;
import com.uds.pautando.core.error.exception.TitleAndDescriptionAndAuthorNotProvidedException;
import com.uds.pautando.core.error.exception.TitleAndDescriptionAndDetailsAndAuthorNotProvidedException;
import com.uds.pautando.core.error.exception.TitleAndDescriptionAndDetailsNotProvidedException;
import com.uds.pautando.core.error.exception.TitleAndDescriptionNotProvidedException;
import com.uds.pautando.core.error.exception.TitleAndDetailsNotProvidedException;
import com.uds.pautando.core.validators.Author;
import com.uds.pautando.core.validators.Description;
import com.uds.pautando.core.validators.Details;
import com.uds.pautando.core.validators.Name;
import com.uds.pautando.core.validators.Title;

public class MeetingAgenda {
    private Title title;
    private Description description;
    private Details details;
    private Author author;
    private boolean status;

    public MeetingAgenda(String titleValue, String descriptionValue, String detailsValue, String authorValue) throws Exception{
        if(isEmpty(titleValue) && isEmpty(descriptionValue) && isEmpty(detailsValue) && isEmpty(authorValue)) {
            throw new TitleAndDescriptionAndDetailsAndAuthorNotProvidedException();
        }else if(isEmpty(descriptionValue) && isEmpty(detailsValue) && isEmpty(authorValue)) {
            throw new DescriptionAndDetailsAndAuthorNotProvidedException();
        }else if(isEmpty(titleValue) && isEmpty(descriptionValue) && isEmpty(detailsValue)) {
            throw new TitleAndDescriptionAndDetailsNotProvidedException();
        }else if(isEmpty(titleValue) && isEmpty(descriptionValue) && isEmpty(authorValue)) {
            throw new TitleAndDescriptionAndAuthorNotProvidedException();
        }else if(isEmpty(descriptionValue) && isEmpty(detailsValue)) {
            throw new DescriptionAndDetailsNotProvidedException();
        }else if(isEmpty(detailsValue) && isEmpty(authorValue)) {
            throw new DetailsAndAuthorNotProvidedException();
        }else if(isEmpty(titleValue) && isEmpty(descriptionValue)) {
            throw new TitleAndDescriptionNotProvidedException();
        }else if(isEmpty(titleValue) && isEmpty(detailsValue)) {
            throw new TitleAndDetailsNotProvidedException();
        }else if(isEmpty(descriptionValue) && isEmpty(authorValue)) {
            throw new DescriptionAndAuthorNotProvidedException();
        }else {
            this.title = new Title(titleValue);
            this.description = new Description(descriptionValue);
            this.details = new Details(detailsValue);
            this.author = new Author(authorValue);
            this.status = true;
        }
    }

    public Title getTitle() {
        return title;
    }

    public Description getDescription() {
        return description;
    }

    public Details getDetails() {
        return details;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean isStatus() {
        return status;
    }

    boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
