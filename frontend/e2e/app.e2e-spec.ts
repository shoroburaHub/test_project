import { FronendPage } from './app.po';

describe('fronend App', () => {
  let page: FronendPage;

  beforeEach(() => {
    page = new FronendPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
