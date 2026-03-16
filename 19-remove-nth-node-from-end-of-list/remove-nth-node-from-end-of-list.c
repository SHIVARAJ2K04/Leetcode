struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    struct ListNode dummy;
    dummy.next = head;
    struct ListNode *fast = &dummy;
    struct ListNode *slow = &dummy;

    // Move the fast pointer n + 1 steps ahead
    for (int i = 0; i <= n; ++i) {
        fast = fast->next;
    }

    // Move both fast and slow pointers until fast reaches the end
    while (fast) {
        fast = fast->next;
        slow = slow->next;
    }

    // Remove the nth node from the end
    slow->next = slow->next->next;

    return dummy.next; // Return the head of the modified list
}

// Helper function to create a new node
struct ListNode* createNode(int value) {
    struct ListNode* newNode = (struct ListNode*)malloc(sizeof(struct ListNode));
    newNode->val = value;
    newNode->next = NULL;
    return newNode;
}

// Helper function to print the list
void printList(struct ListNode* head) {
    while (head) {
        printf("%d -> ", head->val);
        head = head->next;
    }
    printf("NULL\n");
}